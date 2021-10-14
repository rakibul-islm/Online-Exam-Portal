import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExamService } from 'src/app/services/exam.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-exam',
  templateUrl: './update-exam.component.html',
  styleUrls: ['./update-exam.component.css']
})
export class UpdateExamComponent implements OnInit {

  constructor(
    private _route: ActivatedRoute,
    private _exam: ExamService,
    private _router: Router
  ) {}

  exId = 0;
  exam:any;

  ngOnInit(): void {
    this.exId = this._route.snapshot.params.exId;
    //alert(this.exId);
    this._exam.getExam(this.exId).subscribe(
      (data: any) => {
        this.exam = data;
        console.log(this.exam);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  //update form submit
  public updateData() {
    //validatate

    this._exam.updateExam(this.exam).subscribe(
      (data) => {
        Swal.fire('Success !!', 'exam updated', 'success').then((e) => {
          this._router.navigate(['/admin/exams']);
        });
      },
      (error) => {
        Swal.fire('Error', 'error in updating exam', 'error');
        console.log(error);
      }
    );
  }
}
