import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import { ExamService } from 'src/app/services/exam.service';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-view-exam-questions',
  templateUrl: './view-exam-questions.component.html',
  styleUrls: ['./view-exam-questions.component.css']
})
export class ViewExamQuestionsComponent implements OnInit {

  exId:any;
  qTitle:any;
  questions:any = [];

  constructor(
    private _route: ActivatedRoute,
    private _question: QuestionService,
    private _snak: MatSnackBar,
  ) {}

  ngOnInit(): void {
    this.exId = this._route.snapshot.params.exId;
    this.qTitle = this._route.snapshot.params.title;
    this._question.getQuestionsOfExam(this.exId).subscribe(
      (data: any) => {
       // console.log(data);
        this.questions = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  //delete quesion
  deleteQuestion(qid:any) {
    Swal.fire({
      icon: 'info',
      showCancelButton: true,
      confirmButtonText: 'Delete',
      title: 'Are you sure , want to delete this question?',
    }).then((result) => {
      if (result.isConfirmed) {
        //confim
        this._question.deleteQuestion(qid).subscribe(
          (data) => {
            this._snak.open('Question Deleted ', '', {
              duration: 3000,
            });
            this.questions = this.questions.filter((q:any) => q.quesId != qid);
          },

          (error) => {
            this._snak.open('Error in deleting questions', '', {
              duration: 3000,
            });
            console.log(error);
          }
        );
      }
    });
  }
}