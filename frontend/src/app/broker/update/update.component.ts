import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Broker } from '../broker';
import { BrokerServiceService } from '../broker-service.service';
@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']

})
export class UpdateComponent implements OnInit {
  brokid:number;
  brok:Broker;

  
  constructor(private actRouter:ActivatedRoute, private bService:BrokerServiceService, private router:Router) { }

  ngOnInit(): void {
    this.brok=new Broker();
    this.brokid=this.actRouter.snapshot.params['userId'];
    this.bService.getBrokerById(this.brokid).subscribe(data=>{
      this.brok=data;
    })
  }
  updateData(){
    this.bService.updateBroker(this.brok).subscribe(res=>{
      this.router.navigate(['broker']);
    })
  }

}