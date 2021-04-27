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
      broName:[''],
      custName:[''],
      name:['',Validators.required],
      email:['',[Validators.required, Validators.pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")]],
      password:['',Validators.required],
      mobile:['',[Validators.required, Validators.pattern("^[7-9][0-9]{9}$")]],
      city:['',Validators.required],
      Role:['',Validators.required],
    })
  }

  get name(){
    return this.signupForm.get('name');
  }
  get email(){
    return this.signupForm.get('email');
  }
  get password(){
    return this.signupForm.get('password');
  }
  get mobile(){
    return this.signupForm.get('mobile');
  }
  get city(){
    return this.signupForm.get('city');
  }
  get Role(){
    return this.signupForm.get("Role");
  }

  signup(){
    console.log(this.signupForm.value)
    if(this.signupForm.value.Role=="customer"){
      this.signupForm.value.custName=this.signupForm.value.name
      console.log(this.signupForm.value.broName)
      this.cService.addCustomer(this.signupForm.value).subscribe(res=>{
        this.router.navigate(['login'])
        alert("You have succesfully registered as Customer");
      }, err=>{
        alert("User with this Email or Mobile number already exists. Try with different details");
      })
    }
    else{
      this.signupForm.value.broName=this.signupForm.value.name
      this.bService.addBroker(this.signupForm.value).subscribe(res=>{
        this.router.navigate(['login'])
        alert("You have succesfully registered as Broker");
      }, err=>{
        alert("User with this Email or Mobile number already exists. Try with different details");
      })
    }
    
  }

}
