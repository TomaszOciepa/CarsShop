import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemsComponent } from './items.component';
import { ItemsListComponent } from './items-list/items-list.component';
import { ItemsDataService } from './items-data.service';



@NgModule({
  declarations: [
    ItemsComponent,
    ItemsListComponent
  ],
  imports: [
    CommonModule
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
