import { Component, OnInit } from '@angular/core';
import { ItemsDataService } from '../items-data.service';

@Component({
  selector: 'app-items-list',
  templateUrl: './items-list.component.html',
  styleUrls: ['./items-list.component.css']
})
export class ItemsListComponent implements OnInit {


  items = []

  constructor(private service: ItemsDataService ) {
    this.items = service.getData()
   }

  ngOnInit() {
  }

}
