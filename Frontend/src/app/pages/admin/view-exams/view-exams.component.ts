import { Component, OnInit } from '@angular/core';
import { ExamService } from 'src/app/services/exam.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-exams',
  templateUrl: './view-exams.component.html',
  styleUrls: ['./view-exams.component.css']
})
export class ViewExamsComponent implements OnInit {

  exams:any = [];

  constructor(private _exam: ExamService) {}

  ngOnInit(): void {
    this._exam.exams().subscribe(
      (data: any) => {
        this.exams = data;
        console.log(this.exams);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !', 'Error in loading data !', 'error');
      }
    );
  }

  //
  deleteExam(qId:any) {
    Swal.fire({
      icon: 'info',
      title: 'Are you sure ?',
      confirmButtonText: 'Delete',
      showCancelButton: true,
    }).then((result) => {
      if (result.isConfirmed) {
        //delete...

        this._exam.deleteExam(qId).subscribe(
          (data) => {
            this.exams = this.exams.filter((exam:any) => exam.qId != qId);
            Swal.fire('Success', 'Exam deleted ', 'success');
          },
          (error) => {
            Swal.fire('Error', 'Error in deleting exam', 'error');
          }
        );
      }
    });
  }
}