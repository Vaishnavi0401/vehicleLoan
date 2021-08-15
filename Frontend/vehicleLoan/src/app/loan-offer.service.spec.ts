import { TestBed } from '@angular/core/testing';

import { LoanOfferService } from './loan-offer.service';

describe('LoanOfferService', () => {
  let service: LoanOfferService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoanOfferService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
