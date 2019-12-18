import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


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
      }, error => {
        if(error instanceof HttpErrorResponse){
          console.error(error)
        }
      })
  }

  constructor(private http:HttpClient) { }
}
