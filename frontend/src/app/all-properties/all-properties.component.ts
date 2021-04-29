import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PropertyServiceService } from '../property-service.service';

@Component({
  selector: 'app-all-properties',
  templateUrl: './all-properties.component.html',
  styleUrls: ['./all-properties.component.css'],
})
export class AllPropertiesComponent implements OnInit {
  properties: any;
  constructor(
    private pService: PropertyServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.pService.getAllProperties().subscribe((data) => {
      this.properties = data;
    });
  }

  delete(id: number) {
    this.pService.deleteProperty(id).subscribe((data) => {
      this.getAll();
    });
  }
}
