import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPropertiesComponent } from './customer-properties.component';

describe('CustomerPropertiesComponent', () => {
  let component: CustomerPropertiesComponent;
  let fixture: ComponentFixture<CustomerPropertiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerPropertiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerPropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
