import { Component, OnInit } from '@angular/core';
import { PropertyServiceService } from 'src/app/property-service.service';

@Component({
  selector: 'app-all-property-by-criteria',
  templateUrl: './all-property-by-criteria.component.html',
  styleUrls: ['./all-property-by-criteria.component.css']
})
export class AllPropertyByCriteriaComponent implements OnInit {

  properties: any[]
  constructor(private pService: PropertyServiceService) { }

  ngOnInit(): void {
    this.pService.getPropertyByCriteria(this.pService.getCriteria()).subscribe(data => {
      this.properties = data
    });
  }

}
