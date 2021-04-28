import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBrokerComponent } from './admin-broker.component';

describe('AdminBrokerComponent', () => {
  let component: AdminBrokerComponent;
  let fixture: ComponentFixture<AdminBrokerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminBrokerComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBrokerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
