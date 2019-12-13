import { Injectable, EventEmitter } from '@angular/core'; 

@Injectable({
  providedIn: 'root'
})
export class SelectionService<T > {

  constructor() { }

  selection:T

  setSelection(item:T){
    this.selection = item
    this.selectionChange.emit(this.selection)
  }

  selectionChange = new EventEmitter<T>()

}
