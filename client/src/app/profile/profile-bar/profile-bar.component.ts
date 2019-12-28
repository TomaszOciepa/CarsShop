import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { User } from '../models/user';

@Component({
  selector: 'profile-bar',
  templateUrl: './profile-bar.component.html',
  styleUrls: ['./profile-bar.component.css']
})
export class ProfileBarComponent implements OnInit {

  profile:User

  constructor(private profileService:ProfileService) { }

  ngOnInit() {
    this.profileService.getUserProfile().subscribe(user =>{
      this.profile = user
     }) 
  }

}
