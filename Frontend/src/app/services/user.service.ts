import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Base_URL from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // add registered user
  public addUser(user:any){
    return this.http.post(`${Base_URL}/user/`,user)
  }

  // add candidate
  public addCandidate(candidate:any){
    return this.http.post(`${Base_URL}/user/candidate/`,candidate)
  }

  // update candidate
  public updateCandidate(user:any){
    return this.http.put(`${Base_URL}/user/`,user)
  }

  //get candidates
  public getUsersOfExam(qid:any) {
    return this.http.get(`${Base_URL}/user/exam/${qid}`);
  }

  //get single user
  public getUser(username:any) {
    return this.http.get(`${Base_URL}/user/${username}`);
  }

  //delete candidate
  public deleteCandidate(qid:any) {
    return this.http.delete(`${Base_URL}/user/${qid}`);
  }
}
