import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Base_URL from './helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private _http: HttpClient) {}
  //load all the cateogries
  public categories() {
    return this._http.get(`${Base_URL}/category/`);
  }

  //add new category
  public addCategory(category:any) {
    return this._http.post(`${Base_URL}/category/`, category);
  }
}
