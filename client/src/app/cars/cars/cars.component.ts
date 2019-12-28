import { Component, OnInit } from '@angular/core';
import { CarsService } from '../cars.service';
import { Car } from '../model/car';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})

export class CarsComponent implements OnInit {

  cars:Car

  constructor(private carService:CarsService) { }

  ngOnInit() {
    const carList$ = this.carService.getCars()

    carList$.subscribe(c =>{
      this.cars = c
    })
  }

}
