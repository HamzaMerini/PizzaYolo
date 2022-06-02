import { TestBed } from '@angular/core/testing';

import { BoissonServiceService } from './boisson-service.service';

describe('BoissonServiceService', () => {
  let service: BoissonServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BoissonServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
