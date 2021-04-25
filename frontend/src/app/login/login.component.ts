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

  constructor(private fb:FormBuilder, private uService:UserServiceService, private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.fb.group({
      email:['',Validators.required],
      password:['',Validators.required]
    })
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
      else{
        //alert("Enter correct userId and Password");
        this.router.navigate(['/login'])
      }
      })
    
  }
  

}
