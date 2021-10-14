import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable} from '@angular/core';
import Base_URL from './helper';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
  pipe:any;
  exam:any;
  date:any;
  sysdate:any;

  constructor(private _http: HttpClient) { }

  public exams() {
    return this._http.get(`${Base_URL}/exam/`);
  }

  //add exam
  public addExam(exam: any) {
    
    return this._http.post(`${Base_URL}/exam/`, exam);
  }

  //delete exam
  public deleteExam(qId: any) {
    return this._http.delete(`${Base_URL}/exam/${qId}`);
  }

  //get the single exam

  public getExam(qId: any) {
    
    return this._http.get(`${Base_URL}/exam/${qId}`);
  }

  //update exam
  public updateExam(exam: any) {
    return this._http.put(`${Base_URL}/exam/`, exam);
  }


  //qet active exams
  public getActiveExams() {
    return this._http.get(`${Base_URL}/exam/active`);
  }


  

}