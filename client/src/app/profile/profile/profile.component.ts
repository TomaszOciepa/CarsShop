import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { User } from '../models/user';

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  profile:User
  
  constructor(private profileService:ProfileService) { }

  ngOnInit() {
    const profile$ = this.profileService.getUserProfile()

    profile$.subscribe(user =>{
      this.profile = user
    })
  }

}
