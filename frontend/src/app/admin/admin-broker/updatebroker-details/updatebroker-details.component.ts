import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Broker } from 'src/app/broker/broker';
import { BrokerServiceService } from 'src/app/broker/broker-service.service';

@Component({
  selector: 'app-updatebroker-details',
  templateUrl: './updatebroker-details.component.html',
  styleUrls: ['./updatebroker-details.component.css']
})
export class UpdatebrokerDetailsComponent implements OnInit {

  broId:number
  broker:Broker;
  pass:string;

  constructor(private actRouter:ActivatedRoute, private bService:BrokerServiceService, private router:Router) { }

  ngOnInit(): void {
    this.broId=this.actRouter.snapshot.params['userid'];
    console.log("============================"+this.broId+"===============================")
    this.bService.getBrokerById(this.broId).subscribe(data=>{
      this.broker=data;
    })
  }
  updateBroker(){
    if(this.broker.password==this.pass)
    {
      this.bService.updateBroker(this.broker).subscribe(res=>{
        this.router.navigate(['/admin/broker'])
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
