import { Component, OnInit } from '@angular/core';
import { DealServiceService } from 'src/app/deal-service.service';

@Component({
  selector: 'app-admin-deal',
  templateUrl: './admin-deal.component.html',
  styleUrls: ['./admin-deal.component.css']
})
export class AdminDealComponent implements OnInit {
  deals:any
  property:any
  customer:any
  constructor(private dService: DealServiceService) { }

  ngOnInit(): void {
    this.dService.getAllDeals().subscribe(data=>{
      this.deals=data
    })
  }

}
