import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Base_URL from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private _http: HttpClient) {}

  public quizzes() {
    return this._http.get(`${Base_URL}/quiz/`);
  }

  //add quiz
  public addQuiz(quiz:any) {
    return this._http.post(`${Base_URL}/quiz/`, quiz);
  }

  //delete quiz
  public deleteQuiz(qId:any) {
    return this._http.delete(`${Base_URL}/quiz/${qId}`);
  }

  //get the single quiz

  public getQuiz(qId:any) {
    return this._http.get(`${Base_URL}/quiz/${qId}`);
  }

  //update quiz
  public updateQuiz(quiz:any) {
    return this._http.put(`${Base_URL}/quiz/`, quiz);
  }

  //get quizzes of category
  public getQuizzesOfCategory(cid:any) {
    return this._http.get(`${Base_URL}/quiz/category/${cid}`);
  }
  //qet active quizzes
  public getActiveQuizzes() {
    return this._http.get(`${Base_URL}/quiz/active`);
  }

  //get active quizzes of category
  public getActiveQuizzesOfCategory(cid:any) {
    return this._http.get(`${Base_URL}/quiz/category/active/${cid}`);
  }
}