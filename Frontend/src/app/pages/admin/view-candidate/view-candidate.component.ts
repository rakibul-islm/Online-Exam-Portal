import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-candidate',
  templateUrl: './view-candidate.component.html',
  styleUrls: ['./view-candidate.component.css']
})
export class ViewCandidateComponent implements OnInit {

  id:any;
  exId:any;
  user:any = [];

  constructor(
    private _route: ActivatedRoute,
    private _service: UserService,
    private _snak: MatSnackBar,
  ) {}

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

  //delete candidate
  deleteCandidate(qid:any) {
    Swal.fire({
      icon: 'info',
      showCancelButton: true,
      confirmButtonText: 'Delete',
      title: 'Are you sure , want to delete this Candidate?',
    }).then((result) => {
      if (result.isConfirmed) {
        //confim
        this._service.deleteCandidate(qid).subscribe(
          (data) => {
            this._snak.open('Candidate Deleted ', '', {
              duration: 3000,
            });
            this.user = this.user.filter((q:any) => q.quesId != qid);
          },

          (error) => {
            this._snak.open('Error in deleting Candidate', '', {
              duration: 3000,
            });
            console.log(error);
          }
        );
      }
    });
  }
}
