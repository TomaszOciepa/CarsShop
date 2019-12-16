import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { ProfileService } from './profile.service';
import { HttpClientModule } from '@angular/common/http';
import { ProfileBarComponent } from './profile-bar/profile-bar.component';



@NgModule({
  declarations: [ProfileComponent, ProfileBarComponent],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [ProfileComponent, ProfileBarComponent],
  providers:[
    ProfileService
  ]
})
export class ProfileModule { }
