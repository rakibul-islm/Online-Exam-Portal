import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-candidate-dashboard',
  templateUrl: './candidate-dashboard.component.html',
  styleUrls: ['./candidate-dashboard.component.css']
})
export class CandidateDashboardComponent implements OnInit {

  
  pipe: any;
  user: any = null;
  constructor(private login: LoginService) { }

  ngOnInit(): void {
    this.user = this.login.getUser();
    this.pipe = new DatePipe('en-US');
    this.user.exam.date = this.pipe.transform(this.user.exam.date, 'longDate'); 
  }
}
