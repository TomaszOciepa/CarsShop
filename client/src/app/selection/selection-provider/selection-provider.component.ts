import { Component, OnInit } from '@angular/core';
import { SelectionService } from '../selection.service';

@Component({
  selector: 'app-selection-provider',
  templateUrl: './selection-provider.component.html',
  styleUrls: ['./selection-provider.component.css'],
  providers: [
    SelectionService
  ]
})
export class SelectionProviderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
