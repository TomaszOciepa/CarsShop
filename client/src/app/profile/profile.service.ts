import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { City } from './models/city';
import { Subject } from 'rxjs/internal/Subject';
import { multicast, refCount, share } from 'rxjs/internal/operators';
import { ConnectableObservable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  api_url = 'http://api.openweathermap.org/data/2.5/weather?q=gdansk&units=metric&APPID=58fb0cad9835fc6ae2462d0a0bfa99c5'

  city_request = this.http.get<City>(this.api_url)
    .pipe(
      // multicast(new Subject<City>()),
      // refCount()
      share()
    )
  
  // cityData = new Subject<City>()

  getCity(){
    // return this.cityData.asObservable()
    return this.city_request
  }

  constructor(private http:HttpClient) { 
    // this.city_request.subscribe(city =>{
    //   this.cityData.next(city)
    // })

    // (<ConnectableObservable<City>>this.city_request).connect()
  }




}
