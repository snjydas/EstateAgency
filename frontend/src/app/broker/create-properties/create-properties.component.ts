import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PropertyServiceService } from 'src/app/property-service.service';
import { UserServiceService } from 'src/app/user-service.service';
import { Broker } from '../broker';
import { BrokerServiceService } from '../broker-service.service';

@Component({
  selector: 'app-create-properties',
  templateUrl: './create-properties.component.html',
  styleUrls: ['./create-properties.component.css']
})
export class CreatePropertiesComponent implements OnInit {
  propForm:FormGroup;
  broker:any;
  constructor(private fb: FormBuilder,private uService:UserServiceService,private bService:BrokerServiceService, private pService: PropertyServiceService, private router:Router) { }

  ngOnInit(): void {
    this.broker={userId:this.uService.getId()}
    this.propForm = this.fb.group({
      configuration:['',Validators.required],
      offerType: ['', Validators.required],
      offerCost: ['', Validators.required],
      areaSqft:['', Validators.required],
      city:['', Validators.required],
      address:['', Validators.required],
      street:['', Validators.required],
      status:['', Validators.required],
      broker:[this.broker]
    })
  }
  regProperty(){
    this.pService.addProperty(this.propForm.value).subscribe(res=>{
      this.router.navigate(['broker/myprops'])
    }, err=>{
      console.log(err);
    });
  }

}
