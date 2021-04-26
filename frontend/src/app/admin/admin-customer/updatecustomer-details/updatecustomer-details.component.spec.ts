import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatecustomerDetailsComponent } from './updatecustomer-details.component';

describe('UpdatecustomerDetailsComponent', () => {
  let component: UpdatecustomerDetailsComponent;
  let fixture: ComponentFixture<UpdatecustomerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatecustomerDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatecustomerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
