import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemsModule } from './items/items.module';
import { SelectionModule } from './selection/selection.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ItemsModule.forRoot(),
    SelectionModule
  ],
  providers: [
    
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
