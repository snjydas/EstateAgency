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
  message: string;
  loginForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router,
    private uService: UserServiceService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      uname: ['', Validators.required],
      password: ['', Validators.required]
    })
  }
  login() {
    if (this.uService.login(this.loginForm.value)) {
      
      this.router.navigate(['user']);
    }
    else {
      this.message = "Invalid Login, Please check ID and Password";
      this.router.navigate(['/']);
    }

  }
}
