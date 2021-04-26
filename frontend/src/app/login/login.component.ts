import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private role:string
  loginForm:FormGroup
  private allow:boolean;

  alert:boolean
  
  

  constructor(private fb:FormBuilder, private uService:UserServiceService, private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.fb.group({
      email:['',Validators.required],
      password:['',Validators.required]
    })
  }

  get email(){
    return this.loginForm.get('email')
  }

  get password(){
    return this.loginForm.get('password')
  }


  login(){
    this.uService.login(this.loginForm.value).subscribe(data=>{
      this.allow=data;
      if(this.allow){
        this.uService.getUserByEmail(this.loginForm.value.email).subscribe(data=>{
          this.role=data.role
          this.uService.setId(data.userId);
          if(this.role=="Broker"){
            this.router.navigate(['/broker'])
          }
          else if(this.role=="Admin"){
            this.router.navigate(['/admin'])
          }
          else{
            this.router.navigate(['/customer'])
          }
        })
      }
      }, err=>{
        this.alert=true
      })
    
  }
  

}
