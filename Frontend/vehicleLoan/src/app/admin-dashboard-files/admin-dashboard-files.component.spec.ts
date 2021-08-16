import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDashboardFilesComponent } from './admin-dashboard-files.component';

describe('AdminDashboardFilesComponent', () => {
  let component: AdminDashboardFilesComponent;
  let fixture: ComponentFixture<AdminDashboardFilesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDashboardFilesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDashboardFilesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
