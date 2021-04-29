import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BrokService } from '../brok.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  broForm!: FormGroup;

  constructor(private fb: FormBuilder, private bService: BrokService, private router:Router) { }


  ngOnInit(): void {
    this.broForm = this.fb.group({
      broName:['',[Validators.required, Validators.pattern("[a-zA-Z]{3,}$")]],
      email:['',[Validators.required, Validators.pattern("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")]],
      password: ['',[Validators.required, Validators.pattern("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$")]],
      mobile:['',[Validators.required, Validators.pattern("^[7-9][0-9]{9}$")]],
      city:['', Validators.required]
    })
  }
  get name(){
    return this.broForm.get('broName');
  }
  get email(){
    return this.broForm.get('email');
  }
  get password(){
    return this.broForm.get('password');
  }
  get mobile(){
    return this.broForm.get('mobile');
  }
  get city(){
    return this.broForm.get('city');
  }
  regBroker(){
    this.bService.addBroker(this.broForm.value).subscribe(res=>{
      this.router.navigate(['/admin/broker'])
    }, err=>{
      alert("User exists with this Email or mobile number")
      console.log(err);
    });
  }

}
