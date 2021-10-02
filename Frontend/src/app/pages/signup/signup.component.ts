import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService, private _snackBar: MatSnackBar) { }


  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  }



  ngOnInit(): void {
  }

  formSubmit() {
    console.log(this.user);

    if(this.user.username==''||this.user.username==null){
      this._snackBar.open("User Name is Required !!", 'OK',{duration:3000});
      return;
    }
    if(this.user.password==''||this.user.password==null){
      this._snackBar.open("Password is Required !!", 'OK',{duration:3000});
      return;
    }

    if(this.user.firstName==''||this.user.firstName==null){
      this._snackBar.open("First Name is Required !!", 'OK',{duration:3000});
      return;
    }

    if(this.user.lastName==''||this.user.lastName==null){
      this._snackBar.open("Last Name is Required !!", 'OK',{duration:3000});
      return;
    }

    if(this.user.email==''||this.user.email==null){
      this._snackBar.open("Email Address is Required !!", 'OK',{duration:3000});
      return;
    }

    if(this.user.phone==''||this.user.phone==null){
      this._snackBar.open("Mobile Number is Required !!", 'OK',{duration:3000});
      return;
    }

this.userService.addUser(this.user).subscribe(
  (data:any)=>{
    console.log(data);
    // this.user.username= '',
    // this.user.password= '',
    // this.user.firstName= '',
    // this.user.lastName= '',
    // this.user.email= '',
    // this.user.phone= ''
    
    //alert('success !!')
   // this._snackBar.open("Success !!", 'OK',{duration:3000})
   Swal.fire('Successfully done !!',data.firstName +' '+ data.lastName +', User Id '+data.id,'success')
  },
  (error)=>{
    console.log(error);
   // alert('Something went wrong !!')
    this._snackBar.open(error.error.text, 'OK',{duration:5000})
  }
  )

  }

}
