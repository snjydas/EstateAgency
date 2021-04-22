import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;
  message:string;

  constructor(private fb:FormBuilder, private router:Router,
    private lService:LoginServiceService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      uname: ['',Validators.required],
      password:['',Validators.required]
    })
  }
  login(){
    if(this.lService.validateLogin(this.loginForm.value)){
      this.lService.setLoginStatus(true);
      this.router.navigate(['broker']);
    }
    else{
      this.message="Invalid Login, Please check ID and Password";
      this.router.navigate(['/']);
    }
    
  }

}