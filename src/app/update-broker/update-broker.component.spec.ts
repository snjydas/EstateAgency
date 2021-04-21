import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBrokerComponent } from './update-broker.component';

describe('UpdateBrokerComponent', () => {
  let component: UpdateBrokerComponent;
  let fixture: ComponentFixture<UpdateBrokerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateBrokerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBrokerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
