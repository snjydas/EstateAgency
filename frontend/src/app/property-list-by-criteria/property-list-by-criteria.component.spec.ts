import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyListByCriteriaComponent } from './property-list-by-criteria.component';

describe('PropertyListByCriteriaComponent', () => {
  let component: PropertyListByCriteriaComponent;
  let fixture: ComponentFixture<PropertyListByCriteriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PropertyListByCriteriaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PropertyListByCriteriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
