import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-candidate',
  templateUrl: './update-candidate.component.html',
  styleUrls: ['./update-candidate.component.css']
})
export class UpdateCandidateComponent implements OnInit {

  constructor(
    private _route: ActivatedRoute,
    private _user: UserService,
    private _router: Router
  ) {}

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

  ngOnInit(): void {
    this.exId = this._route.snapshot.params.exId;
    this.username = this._route.snapshot.params.username;
    
    this._user.getUser(this.username).subscribe(
      (data: any) => {
        this.user = data;
        this.user.authorities = null;
        //console.log(this.user);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  //update form submit
  public updateCandidate() {
    //validatate

    this._user.updateCandidate(this.user).subscribe(
      (data) => {
        Swal.fire('Success !!', 'Candidate updated', 'success').then((e) => {
          this._router.navigate(['/admin/view-candidate/'+ this.exId]);
        });
      },
      (error) => {
        Swal.fire('Error', 'error in updating Candidate', 'error');
        console.log(error);
      }
    );
  }
}
