import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    username: '',
    password: ''

  };



  constructor(
    private loginservice: LoginService,
    private _snackBar: MatSnackBar,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  formSubmit() {

    if (this.loginData.username.trim() == '' || this.loginData.username == null) {
      this._snackBar.open("User Name is Required !!", 'OK', { duration: 3000 });
      return;
    }
    if (this.loginData.password.trim() == '' || this.loginData.password == null) {
      this._snackBar.open("Password is Required !!", 'OK', { duration: 3000 });
      return;
    }

 

    // request to server to generate token

    this.loginservice.generateToken(this.loginData).subscribe(
      (data: any) => {
        console.log('Success');
        //console.log(data);


        //login...
        this.loginservice.loginUser(data.token);

        this.loginservice.getCurrentUser().subscribe((user: any) => {
          this.loginservice.setUser(user);
         // console.log(user);
          //redirect ...ADMIN: admin-dashboard
          //redirect ...NORMAL:normal-dashboard
          if (this.loginservice.getUserRole() == 'ADMIN') {
            //admin dashboard
            //window.location.href = '/admin';

            this.router.navigate(['admin']);
            this.loginservice.loginStatusSubject.next(true);
          } else if (this.loginservice.getUserRole() == 'NORMAL') {
            //normal user dashbaord
            // window.location.href = '/user';

            this.router.navigate(['user']);
            this.loginservice.loginStatusSubject.next(true);
          }else if (this.loginservice.getUserRole() == 'CANDIDATE') {
            //candidate dashbaord

            this.router.navigate(['candidate']);
            this.loginservice.loginStatusSubject.next(true);
          }else {
            this.loginservice.logout();
          }
        });


      },
      (error) => {
        console.log('Error');
        console.log(error);
        this._snackBar.open("Invalid details !   Please try again.", 'OK', { duration: 3000 });
      }
    )





  }

}
