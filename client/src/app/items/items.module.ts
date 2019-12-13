import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemsComponent } from './items.component';
import { ItemsListComponent } from './items-list/items-list.component';
import { ItemsDataService } from './items-data.service';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    ItemsComponent,
    ItemsListComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    ItemsComponent,
    ItemsListComponent
  ],
  providers: [
    
  ]
})
export class ItemsModule { 

static forRoot():ModuleWithProviders{

  return {
      ngModule: ItemsModule,
      providers: [
        ItemsDataService
      ]
  }
}

}
