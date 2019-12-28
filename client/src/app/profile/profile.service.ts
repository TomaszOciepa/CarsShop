import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { multicast, refCount, share, shareReplay, filter, map } from 'rxjs/internal/operators';
import { ConnectableObservable, Observable } from 'rxjs';
import { User } from './models/user';
import { AuthService } from '../auth/auth.service';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  // api_url = 'http://localhost:8080/user/'

  private user_request:Observable<User>

  // city_request = this.http.get<City>(this.api_url)
  //   .pipe(
  //     multicast(new ReplaySubject<City>(1)),
  //     refCount()
  //     // shareReplay()
  //   )
  

  getUserProfile(){
    if(!this.user_request){
      this.user_request = this.auth.state
      .pipe(
        filter(() => this.auth.isAuthenticated),
        map(() => this.auth.getCurrentUser()),
      )
    }
    return this.user_request
  }

  clearCache(){
    this.user_request = null
  }

  constructor(private http:HttpClient, private auth:AuthService) {}




}
