import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DealServiceService } from 'src/app/deal-service.service';
import { PropertyServiceService } from 'src/app/property-service.service';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-deal',
  templateUrl: './deal.component.html',
  styleUrls: ['./deal.component.css']
})
export class DealComponent implements OnInit {
  propId:number;
  prop:any;
  deal:any;
  constructor(private actRouter:ActivatedRoute,private pService:PropertyServiceService, private dService:DealServiceService, private router:Router, private uService:UserServiceService) { }

  ngOnInit(): void {
    this.propId=this.actRouter.snapshot.params['propid'];
    this.pService.getPropertyById(this.propId).subscribe(data=>{
      this.prop=data
    })
  }

  makeDeal(){
    this.deal={
      customer: {
        userId: this.uService.getId()
      },
      dealCost: this.prop.offerCost,
      property: {
        propId: this.propId
      }
    }
    this.dService.addDeal(this.deal).subscribe(ref=>{
      this.router.navigate(['customer/myprops/'])
    })
  }

}
