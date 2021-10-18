import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-admin',
  templateUrl: './update-admin.component.html',
  styleUrls: ['./update-admin.component.css']
})
export class UpdateAdminComponent implements OnInit {

  constructor(
    private _route: ActivatedRoute,
    private _user: UserService,
    private login: LoginService,
    private _router: Router
  ) { }


  username: any;
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
  public updateProfile() {
    //validatate

    this._user.updateCandidate(this.user).subscribe(
      (data) => {
        Swal.fire('Success !!', 'Profile updated, Login Now !', 'success').then((e) => {
          this.login.logout();
          window.location.reload();

        });
      },
      (error) => {
        Swal.fire('Error', 'error in updating Profile', 'error');
        console.log(error);
      }
    );
  }
}
