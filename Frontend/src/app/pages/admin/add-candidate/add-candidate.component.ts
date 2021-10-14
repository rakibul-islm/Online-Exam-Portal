import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-candidate',
  templateUrl: './add-candidate.component.html',
  styleUrls: ['./add-candidate.component.css']
})
export class AddCandidateComponent implements OnInit {

  exId: any;
  user: any = {
    exam: {},
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };

  constructor(
    private _route: ActivatedRoute,
    private _service: UserService
  ) { }

  ngOnInit(): void {
    this.exId = this._route.snapshot.params.exId;
    this.user.exam['exId'] = this.exId;
  }

  formSubmit() {
    if (this.user.username.trim() == '' || this.user.username == null) {
      return;
    }

    if (this.user.password.trim() == '' || this.user.password == null) {
      return;
    }
    if (this.user.firstName.trim() == '' || this.user.firstName == null) {
      return;
    }
    if (this.user.lastName.trim() == '' || this.user.lastName == null) {
      return;
    }
    if (this.user.email.trim() == '' || this.user.email == null) {
      return;
    }
    if (this.user.phone.trim() == '' || this.user.phone == null) {
      return;
    }

    //form submit
    this._service.addCandidate(this.user).subscribe(
      (data: any) => {
        Swal.fire('Success ', 'Candidate Added. Add Another one', 'success');
        this.user.username = '';
        this.user.password = '';
        this.user.firstName = '';
        this.user.lastName = '';
        this.user.email = '';
        this.user.phone = '';
      },
      (error) => {
        Swal.fire('Error', 'Error in adding Candidate', 'error');
      }
    );
  }
}