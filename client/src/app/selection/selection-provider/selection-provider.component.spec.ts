import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectionProviderComponent } from './selection-provider.component';

describe('SelectionProviderComponent', () => {
  let component: SelectionProviderComponent;
  let fixture: ComponentFixture<SelectionProviderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectionProviderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectionProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
