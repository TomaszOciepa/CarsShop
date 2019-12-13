import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SelectionService } from './selection.service';
import { SelectableDirective } from './selectable.directive';



@NgModule({
  declarations: [
    SelectableDirective
  ],
  exports: [
    SelectableDirective
  ],
  imports: [
    CommonModule
  ],
  providers: [
    SelectionService
  ]
})
export class SelectionModule { }
