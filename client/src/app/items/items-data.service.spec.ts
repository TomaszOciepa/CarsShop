import { TestBed } from '@angular/core/testing';

import { ItemsDataService } from './items-data.service';

describe('ItemsDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ItemsDataService = TestBed.get(ItemsDataService);
    expect(service).toBeTruthy();
  });
});
