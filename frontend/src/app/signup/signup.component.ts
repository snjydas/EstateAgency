import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BrokerServiceService } from '../broker/broker-service.service';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm: FormGroup
  constructor(private fb:FormBuilder, private bService:BrokerServiceService, private cService:CustomerServiceService, private router:Router) { }

  ngOnInit(): void {
    this.signupForm=this.fb.group({
      broName:['',Validators.required],
      custName:['',Validators.required],
      name:['',Validators.required],
      email:['',Validators.required],
      password:['',Validators.required],
      mobile:['',Validators.required],
      city:['',Validators.required],
      Role:['',Validators.required],
    })
  }

  signup(){
    console.log(this.signupForm.value)
    if(this.signupForm.value.Role=="customer"){
      this.signupForm.value.custName=this.signupForm.value.name
      console.log(this.signupForm.value.broName)
      this.cService.addCustomer(this.signupForm.value).subscribe(res=>{
        this.router.navigate(['login'])
      })
    }
    else{
      this.signupForm.value.broName=this.signupForm.value.name
      this.bService.addBroker(this.signupForm.value).subscribe(res=>{
        this.router.navigate(['login'])
      })
    }
    
  }

}
