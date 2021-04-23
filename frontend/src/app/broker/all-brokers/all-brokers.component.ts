import { Component, OnInit } from '@angular/core';
import { BrokService } from '../brok.service';
import { Broker } from '../broker';

@Component({
  selector: 'app-all-brokers',
  templateUrl: './all-brokers.component.html',
  styleUrls: ['./all-brokers.component.css']
})
export class AllBrokersComponent implements OnInit {
  broks!:Broker[];
  searchText:any;
  constructor(private bService:BrokService) { }

  ngOnInit(): void {
    this.getAll();

  }
  getAll(){
    this.bService.getAllBroker().subscribe(data=>{
      this.broks=data;
    });
    
  }
  delete(broid:number){
    this.bService.deleteBroker(broid).subscribe(data=>{
      this.getAll();
    })
  }
  

}
