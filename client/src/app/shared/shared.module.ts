import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SelectionModule } from '../selection/selection.module';
import { SelectableDirective } from '../selection/selectable.directive';
import { SelectionProviderComponent } from '../selection/selection-provider/selection-provider.component';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SelectionModule
  ],
  exports: [
    SelectableDirective,
    SelectionProviderComponent
  ]
})
export class SharedModule { }
