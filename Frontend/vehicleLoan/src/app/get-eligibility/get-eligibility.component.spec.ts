import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetEligibilityComponent } from './get-eligibility.component';

describe('GetEligibilityComponent', () => {
  let component: GetEligibilityComponent;
  let fixture: ComponentFixture<GetEligibilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetEligibilityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetEligibilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
