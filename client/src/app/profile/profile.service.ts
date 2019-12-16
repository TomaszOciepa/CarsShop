import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { City } from './models/city';
import { Subject } from 'rxjs/internal/Subject';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { ReplaySubject } from 'rxjs/internal/ReplaySubject';
import { multicast, refCount, share, shareReplay } from 'rxjs/internal/operators';
import { ConnectableObservable, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  api_url = 'http://api.openweathermap.org/data/2.5/weather?q=gdansk&units=metric&APPID=58fb0cad9835fc6ae2462d0a0bfa99c5'

  private city_request:Observable<City>

  // city_request = this.http.get<City>(this.api_url)
  //   .pipe(
  //     multicast(new ReplaySubject<City>(1)),
  //     refCount()
  //     // shareReplay()
  //   )
  

  getCity(){
    if(!this.city_request){
      this.city_request = this.http.get<City>(this.api_url)
    .pipe(
      shareReplay()
    )
    }
    return this.city_request
  }

  clearCache(){
    this.city_request = null
  }

  constructor(private http:HttpClient) {}




}
