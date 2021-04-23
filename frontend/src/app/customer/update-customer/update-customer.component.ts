import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from 'src/app/customer-service.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customer:any;
  pass:string;
  constructor(private cService:CustomerServiceService, private router:Router) { }

  ngOnInit(): void {
    this.cService.getCustomerById(7).subscribe(data=>{
      this.customer=data
    })
  }


  updateCustomer(){
    if(this.customer.password==this.pass)
    {
      this.cService.updateCustomer(this.customer).subscribe(res=>{
        this.router.navigate(['customer'])
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
