import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDealComponent } from './admin-deal.component';

describe('AdminDealComponent', () => {
  let component: AdminDealComponent;
  let fixture: ComponentFixture<AdminDealComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminDealComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDealComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
