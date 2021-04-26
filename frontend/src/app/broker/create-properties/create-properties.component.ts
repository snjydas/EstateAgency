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
  get configuration(){
    return this.propForm.get('configuration');
  }
  get offerType(){
    return this.propForm.get('offerType');
  }
  get offerCost(){
    return this.propForm.get('offerCost');
  }
  get areaSqft(){
    return this.propForm.get('areaSqft');
  }
  get city(){
    return this.propForm.get('city');
  }
  get address(){
    return this.propForm.get('address');
  }
  get street(){
    return this.propForm.get('street');
  }
  get status(){
    return this.propForm.get('status');
  }
  regProperty(){
    this.pService.addProperty(this.propForm.value).subscribe(res=>{
      this.router.navigate(['broker/myprops'])
    }, err=>{
      console.log(err);
    });
  }

}
