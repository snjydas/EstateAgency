import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/user-service.service';
import { Broker } from '../broker';
import { BrokerServiceService } from '../broker-service.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  broker:Broker;
  pass:string;

  constructor(private bService:BrokerServiceService, private router:Router, private uService:UserServiceService) { }

  ngOnInit(): void {
    this.bService.getBrokerById(this.uService.getId()).subscribe(data=>{
      this.broker=data;
    })
  }
  updateBroker(){
    if(this.broker.password==this.pass)
    {
      this.bService.updateBroker(this.broker).subscribe(res=>{
        this.router.navigate(['broker'])
      }, err=>{
        alert("User with this Email or mobile number already exists. Please try with different details")
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
