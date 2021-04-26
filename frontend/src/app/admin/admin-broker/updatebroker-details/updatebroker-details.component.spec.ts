import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatebrokerDetailsComponent } from './updatebroker-details.component';

describe('UpdatebrokerDetailsComponent', () => {
  let component: UpdatebrokerDetailsComponent;
  let fixture: ComponentFixture<UpdatebrokerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatebrokerDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatebrokerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
