import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BrokService } from '../brok.service';
import { Broker } from '../broker';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  brokid:number;
  brok:Broker;

  constructor(private actRouter:ActivatedRoute, private bService:BrokService, private router:Router) { }

  ngOnInit(): void {
    this.brok=new Broker();
    this.brokid=this.actRouter.snapshot.params['userid'];
    this.bService.getBrokerById(this.brokid).subscribe(data=>{
      this.brok=data;
    })
  }
  updateData(){
    this.bService.updateBroker(this.brok).subscribe(res=>{
      this.router.navigate(['broker/all']);
    })
  }

}
