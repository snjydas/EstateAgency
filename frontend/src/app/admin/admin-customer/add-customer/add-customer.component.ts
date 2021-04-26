import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerServiceService } from 'src/app/customer-service.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customerForm: FormGroup
  constructor(private fb:FormBuilder, private cService:CustomerServiceService, private router:Router) { }

  ngOnInit(): void {
    this.customerForm=this.fb.group({
      custName:['',Validators.required],
      email:['',[Validators.required, Validators.pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")]],
      password:['',Validators.required],
      mobile:['',[Validators.required, Validators.pattern("^[7-9][0-9]{9}$")]],
      city:['',Validators.required]
    })
  }

  get custName(){
    return this.customerForm.get('custName');
  }
  get email(){
    return this.customerForm.get('email');
  }
  get password(){
    return this.customerForm.get('password');
  }
  get mobile(){
    return this.customerForm.get('mobile');
  }
  get city(){
    return this.customerForm.get('city');
  }

  signup(){
    this.customerForm.value.Role="customer"
    this.cService.addCustomer(this.customerForm.value).subscribe(res=>{
      this.router.navigate(['/admin/customer'])
    })
    
  }

}
