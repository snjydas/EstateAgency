import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrokerPropertiesComponent } from './broker-properties.component';

describe('BrokerPropertiesComponent', () => {
  let component: BrokerPropertiesComponent;
  let fixture: ComponentFixture<BrokerPropertiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrokerPropertiesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrokerPropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
