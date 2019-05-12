import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models/User';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  
  addUser(user: User) {
    return this.http.post(`http://localhost:4201/api/users/create`, user);
  }
  

  constructor(private http: HttpClient) { }

  getFiles(){
   return this.http.get("https://reqres.in/api/unknown")
  }

}
