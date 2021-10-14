import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamService } from 'src/app/services/exam.service';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-exam-instructions',
  templateUrl: './exam-instructions.component.html',
  styleUrls: ['./exam-instructions.component.css']
})
export class ExamInstructionsComponent implements OnInit {

  exId: any;
  title:any;
  description:any;
  exam: any;
  pipe: any;
  user: any = null;
  sysdate: any;

  constructor(
    private _route: ActivatedRoute,
    private _exam: ExamService,
    private login: LoginService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.exId = this._route.snapshot.params.exId;
    this.title = this._route.snapshot.params.title;
    this.user = this.login.getUser();
    //console.log(this.exId);

    this._exam.getExam(this.exId).subscribe(
      (data: any) => {
       // console.log(data);
        this.exam = data;
      },
      (error) => {
        console.log(error);
        alert('Error in loading exam data');
      }
    );


    this.user = this.login.getUser();
    this.pipe = new DatePipe('en-US');
    this.user.exam.date = this.pipe.transform(this.user.exam.date, 'longDate');

    const now = Date.now();
    this.sysdate = this.pipe.transform(now, 'longDate');
  }

  startExam() {
    Swal.fire({
      title: 'Do you want to start the quiz?',

      showCancelButton: true,
      confirmButtonText: `Start`,
      denyButtonText: `Don't save`,
      icon: 'info',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this._router.navigate(['/exam-start/' + this.exId]);
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info');
      }
    });
  }
}