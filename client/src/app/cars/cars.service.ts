import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../auth/auth.service';
import { Car } from './model/car';

@Injectable({
  providedIn: 'root'
})
export class CarsService {

      api_url = 'http://localhost:8080/car/all'

      
        httpOptions = {
        headers: new HttpHeaders({
          // 'Content-Type':  'application/json',
          'Authorization': this.auth.getToken()
        })
      };

    getCars(){
      return this.http.get<Car>(this.api_url, this.httpOptions)
    }

  constructor(private http:HttpClient, private auth:AuthService) { }
}
