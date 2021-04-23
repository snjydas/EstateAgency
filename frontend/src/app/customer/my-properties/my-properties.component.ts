import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/customer-service.service';

@Component({
  selector: 'app-my-properties',
  templateUrl: './my-properties.component.html',
  styleUrls: ['./my-properties.component.css']
})
export class MyPropertiesComponent implements OnInit {

  properties:any;
  constructor(private cService:CustomerServiceService) { }

  ngOnInit(): void {
    this.cService.getAllProperties(7).subscribe(data=>{
      this.properties=data
    })
  }

}
