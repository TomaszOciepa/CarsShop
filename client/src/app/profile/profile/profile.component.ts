import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { City } from '../models/city'

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  profile:City

  constructor(private profileService:ProfileService) { }

  ngOnInit() {

    this.profileService.getCity().subscribe(response =>{
     this.profile = response
    }) 
  }

}
