import { TestBed } from '@angular/core/testing';

import { EligibilityService } from './eligibility.service';

describe('EligibilityService', () => {
  let service: EligibilityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EligibilityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
