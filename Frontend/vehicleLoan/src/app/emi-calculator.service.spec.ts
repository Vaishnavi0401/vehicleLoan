import { TestBed } from '@angular/core/testing';

import { EmiCalculatorService } from './emi-calculator.service';

describe('EmiCalculatorService', () => {
  let service: EmiCalculatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmiCalculatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
