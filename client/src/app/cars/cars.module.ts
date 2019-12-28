import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsComponent } from './cars/cars.component';
import { CarsService } from './cars.service'
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [CarsComponent],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [CarsComponent],
  providers:[
    CarsService
  ]
})
export class CarsModule { }
