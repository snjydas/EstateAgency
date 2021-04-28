import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private uService: UserServiceService, private router: Router) { }
  ngOnInit(): void {
  }

  login(): boolean {
    return this.uService.getStatus()
  }

  logout() {
    this.uService.setStatus(false)
    this.uService.setUser("none");
  }

}
