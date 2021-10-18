import { DatePipe, Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ExamService } from 'src/app/services/exam.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-exam',
  templateUrl: './add-exam.component.html',
  styleUrls: ['./add-exam.component.css']
})
export class AddExamComponent implements OnInit {


  examData: any = {
    title: '',
    description: '',
    maxMarks: '',
    numberOfQuestions: '',
    active: true,
    date: '',
    time: '',
  };

  constructor(
    private _snack: MatSnackBar,
    private _exam: ExamService,
    private location: Location
  ) { }

  ngOnInit(): void {}
  //
  addExam() {
    if (this.examData.title.trim() == '' || this.examData.title == null) {
      this._snack.open('Title Required !!', '', {
        duration: 3000,
      });
      return;
    }

    //validation...

    //call server
    this._exam.addExam(this.examData).subscribe(
      (data) => {
        Swal.fire('Success', 'exam is added', 'success');
        this.examData = {
          title: '',
          description: '',
          maxMarks: '',
          numberOfQuestions: '',
          active: true,
          date: '',
          time: '',
        };
      },

      (error) => {
        Swal.fire('Error!! ', 'Error while adding exam', 'error');
        console.log(error);
      }
    );
  }

    // back button
    Back(){
      this.location.back();
    }
}