import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Base_URL from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // add user

  public addUser(user:any){
    return this.http.post(`${Base_URL}/user/`,user)

  }
}
