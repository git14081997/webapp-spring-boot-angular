import { TestBed } from '@angular/core/testing';

import { PruebasService } from './pruebas.service';

describe('PruebasService', () => {
  let service: PruebasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PruebasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
