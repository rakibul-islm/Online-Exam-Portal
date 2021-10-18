import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  id: any;
  exId: any;
  pipe: any;
  user: any = [];
  singleUser: any = [];
  emailRequest: any = {
    to: '',
    subject: '',
    message: [
      "Rakib",
      "",
      "",
      "",
      "",
      ""

    ],

  };

  constructor(
    private _route: ActivatedRoute,
    private _service: UserService,
    private _snak: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.exId = this._route.snapshot.params.exId;
    this.id = this._route.snapshot.params.id;
    this._service.getUsersOfExam(this.exId).subscribe(
      (data: any) => {
        //console.log(data);
        this.user = data;
      },
      (error) => {
        console.log(error);
      }
    );
    

  }

  //send email
  sendEmail(username: any) {

    this.singleUser = this._service.getUser(username).subscribe(
      (data: any) => {
       // console.log(data);

        this.singleUser = data;
        this.emailRequest.to = this.singleUser.email;
        this.emailRequest.subject = 'Published Result';
        this.emailRequest.message[0] = this.singleUser.firstName + ' ' + this.singleUser.lastName;
        this.emailRequest.message[1] = this.singleUser.exam.title;
        this.pipe = new DatePipe('en-US');
        this.emailRequest.message[2] = this.pipe.transform(this.singleUser.exam.date, 'longDate');
        this.emailRequest.message[3] = this.singleUser.exam.time;
        this.emailRequest.message[4] = this.singleUser.obtMarks;
        this.emailRequest.message[5] = this.singleUser.exam.maxMarks;
        

        this._service.emailResult(this.emailRequest).subscribe(
          (data) => {
            console.log(data);
            Swal.fire('Success', 'Email Sent !', 'success');
          },
    
          (successs) => {
            Swal.fire('Success', 'Email Sent !', 'success');
            //Swal.fire('Error!! ', 'Error while sending email', 'error');
            console.log(successs);
          }
        );


      },
      (error) => {
        console.log(error);
      }
    );
    
    
  }
}