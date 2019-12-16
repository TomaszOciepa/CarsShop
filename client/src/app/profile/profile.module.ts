import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { ProfileService } from './profile.service';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [ProfileComponent],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [ProfileComponent],
  providers:[
    ProfileService
  ]
})
export class ProfileModule { }
