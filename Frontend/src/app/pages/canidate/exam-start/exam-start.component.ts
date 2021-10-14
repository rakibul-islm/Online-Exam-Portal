import { LocationStrategy } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { QuestionService } from 'src/app/services/question.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-exam-start',
  templateUrl: './exam-start.component.html',
  styleUrls: ['./exam-start.component.css']
})
export class ExamStartComponent implements OnInit {

  qid: any;  
  questions: any;
  exId:any = 0;
  username:any;
  user: any = {
    authorities: null,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };

  marksGot: any = 0;
  correctAnswers: any = 0;
  attempted: any = 0;


  isSubmit = false;

  timer: any;

  constructor(
    private locationSt: LocationStrategy,
    private _route: ActivatedRoute,
    private _question: QuestionService,
    private login: LoginService,
    private _user: UserService,
  ) { }

  ngOnInit(): void {
    this.preventBackButton();
    this.exId = this._route.snapshot.params.exId;
    this.username = this._route.snapshot.params.username;
    this.loadQuestions();

    this.user = this.login.getUser();
    this._user.getUser(this.username).subscribe(
      (data: any) => {
        this.user = data;
        this.user.obtMarks=this.marksGot;
        this.user.authorities = null;
      },
      (error) => {
        console.log(error);
      }
    );
    
  }


  loadQuestions() {
    this._question.getQuestionsOfExamForTest(this.exId).subscribe(
      (data: any) => {
        this.questions = data;

        this.timer = this.questions.length * 1 * 60;

        this.questions.forEach((q: any) => {
          q['givenAnswer'] = '';
        });

        // console.log(this.questions);
        this.startTimer();
      },

      (error) => {
        console.log(error);
        Swal.fire('Error', 'Error in loading questions of exam', 'error');
      }
    );
  }

  preventBackButton() {
    history.pushState(null, '', location.href);
    this.locationSt.onPopState(() => {
      history.pushState(null, '', location.href);
    });
  }

  submitExam() {
    Swal.fire({
      title: 'Do you want to submit the exam?',
      showCancelButton: true,
      confirmButtonText: `Submit`,
      icon: 'info',
    }).then((e) => {
      if (e.isConfirmed) {
        this.evalExam();
        this.user.obtMarks=this.marksGot;
        this.submitMarks();
        this.login.logout();
      }
    });
  }

  startTimer() {
    let t = window.setInterval(() => {
      //code
      if (this.timer <= 0) {
        this.evalExam();
        clearInterval(t);
      } else {
        this.timer--;
      }
    }, 1000);
  }

  getFormattedTime() {
    let mm = Math.floor(this.timer / 60);
    let ss = this.timer - mm * 60;
    return `${mm} min : ${ss} sec`;
  }

  evalExam() {
    //calculation
    this.isSubmit = true;

    this.questions.forEach((q: any) => {
      if (q.givenAnswer == q.answer) {
        this.correctAnswers++;
        let marksSingle =
          this.questions[0].exam.maxMarks / this.questions.length;
        this.marksGot += marksSingle;
      }

      if (q.givenAnswer.trim() != '') {
        this.attempted++;
      }
    });

    

  }

  printComponent(cmpName: any) {
    window.print();
  }

  // submit marks
  public submitMarks() {
   // console.log(this.user);
    this._user.updateCandidate(this.user).subscribe(
      (data) => {
        console.log("submitted result is recorded");
      },
      (error) => {
        console.log(error);
      }
    );
  }


}