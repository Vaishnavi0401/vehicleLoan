import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanOfferComponent } from './loan-offer.component';

describe('LoanOfferComponent', () => {
  let component: LoanOfferComponent;
  let fixture: ComponentFixture<LoanOfferComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanOfferComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
