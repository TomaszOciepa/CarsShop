import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SelectionService } from './selection.service';
import { SelectableDirective } from './selectable.directive';
import { SelectionProviderComponent } from './selection-provider/selection-provider.component';



@NgModule({
  declarations: [
    SelectableDirective,
    SelectionProviderComponent
  ],
  exports: [
    SelectableDirective,
    SelectionProviderComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [
    // SelectionService
  ]
})
export class SelectionModule { }
