import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Base_URL from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private _http: HttpClient) {}

  public getQuestionsOfQuiz(qid:any) {
    return this._http.get(`${Base_URL}/question/quiz/all/${qid}`);
  }


  public getQuestionsOfExam(qid:any) {
    return this._http.get(`${Base_URL}/question/exam/all/${qid}`);
  }

  public getQuestionsOfQuizForTest(qid:any) {
    return this._http.get(`${Base_URL}/question/quiz/${qid}`);
  }

  public getQuestionsOfExamForTest(qid:any) {
    return this._http.get(`${Base_URL}/question/exam/${qid}`);
  }

  //getSingleQuestion
  public getSingleQuestion(quesId:any) {
    return this._http.get(`${Base_URL}/question/${quesId}`);
  }

  //add question
  public addQuestion(question:any) {
    return this._http.post(`${Base_URL}/question/`, question);
  }

  //update question
  public updateQuestion(question:any) {
    return this._http.put(`${Base_URL}/question/`, question);
  }

  //delete question
  public deleteQuestion(questionId:any) {
    return this._http.delete(`${Base_URL}/question/${questionId}`);
  }
}