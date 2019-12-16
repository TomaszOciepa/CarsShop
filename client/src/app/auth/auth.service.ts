import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


interface Credentials{
  username:string;
  password:string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url = 'http://localhost:8090/login'

  login(credentials:Credentials) {
    this.http.post(this.url, credentials)
      .subscribe(response =>{
        console.log(response)
      })
  }

  constructor(private http:HttpClient) { }
}
