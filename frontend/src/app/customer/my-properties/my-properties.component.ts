import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/customer-service.service';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-my-properties',
  templateUrl: './my-properties.component.html',
  styleUrls: ['./my-properties.component.css']
})
export class MyPropertiesComponent implements OnInit {

  properties:any;
  constructor(private cService:CustomerServiceService, private uService:UserServiceService) { }

  ngOnInit(): void {
    this.cService.getAllProperties(this.uService.getId()).subscribe(data=>{
      this.properties=data
    })
  }

}
