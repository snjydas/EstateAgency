import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPropertyByCriteriaComponent } from './all-property-by-criteria.component';

describe('AllPropertyByCriteriaComponent', () => {
  let component: AllPropertyByCriteriaComponent;
  let fixture: ComponentFixture<AllPropertyByCriteriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllPropertyByCriteriaComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllPropertyByCriteriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
