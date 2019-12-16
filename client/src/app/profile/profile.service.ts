import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { City } from './models/city';
@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  api_url = 'http://api.openweathermap.org/data/2.5/weather?q=gdansk&units=metric&APPID=58fb0cad9835fc6ae2462d0a0bfa99c5'

  getCity(){
      return this.http.get<City>(this.api_url)
  }

  constructor(private http:HttpClient) { }




}
