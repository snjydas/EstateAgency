import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private uService:UserServiceService) { }
  ngOnInit(): void {
  }

  login():boolean{
    return this.uService.getStatus()
  }

  logout(){
    this.uService.setStatus(false)
    this.uService.setUser("none");
  }

}
