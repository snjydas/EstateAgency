import { Component, OnInit } from '@angular/core';
import { Property } from 'src/app/property';
import { PropertyServiceService } from 'src/app/property-service.service';
import { BrokService } from '../brok.service';

@Component({
  selector: 'app-my-properties',
  templateUrl: './my-properties.component.html',
  styleUrls: ['./my-properties.component.css']
})
export class MyPropertiesComponentB implements OnInit {
  properties!:Property[];

  constructor(private bService:BrokService, private pService:PropertyServiceService) { }


  ngOnInit(): void {
    this.getProperty();
  }
  getProperty(){
    this.bService.getProperties(1).subscribe(data=>{
      this.properties=data;
    });
  }
  delete(id:number){
    this.pService.deleteProperty(id).subscribe(data=>{
      this.getProperty();
    })
  }

}
