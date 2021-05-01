import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from 'src/app/customer-service.service';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customer:any;
  pass:string;
  constructor(private cService:CustomerServiceService, private router:Router, private uService:UserServiceService) { }

  ngOnInit(): void {
    this.cService.getCustomerById(this.uService.getId()).subscribe(data=>{
      this.customer=data
    })
  }


  updateCustomer(){
    if(this.customer.password==this.pass)
    {
      this.cService.updateCustomer(this.customer).subscribe(res=>{
        this.router.navigate(['customer']);
        alert("Your details updated succesfully")
      }, err=>{
        console.log(err);
      }
      );
    }
    else
    {
      alert("Password must be same as re-entered password")
    }
  
  }
  
}
