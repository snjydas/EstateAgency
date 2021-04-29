import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerServiceService } from 'src/app/customer-service.service';

@Component({
  selector: 'app-updatecustomer-details',
  templateUrl: './updatecustomer-details.component.html',
  styleUrls: ['./updatecustomer-details.component.css']
})
export class UpdatecustomerDetailsComponent implements OnInit {

  custId:number
  customer:any;
  pass:string;
  constructor(private actRouter:ActivatedRoute, private cService:CustomerServiceService, private router:Router) { }

  ngOnInit(): void {
    this.custId=this.actRouter.snapshot.params['userid'];
    this.cService.getCustomerById(this.custId).subscribe(data=>{
      this.customer=data
    })
  }


  updateCustomer(){
    this.cService.updateCustomer(this.customer).subscribe(res=>{
      this.router.navigate(['/admin/customer/all'])
    }, err=>{
      console.log(err);
    }
    );
  }

}
