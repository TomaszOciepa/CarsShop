import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { City } from '../models/city'

@Component({
  selector: 'profile-bar',
  templateUrl: './profile-bar.component.html',
  styleUrls: ['./profile-bar.component.css']
})
export class ProfileBarComponent implements OnInit {

  profile:City

  constructor(private profileService:ProfileService) { }

  ngOnInit() {
    this.profileService.getCity().subscribe(city =>{
      this.profile = city
     }) 
  }

}
