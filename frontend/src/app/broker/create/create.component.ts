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
      broName:['',Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      mobile:['', Validators.required],
      city:['', Validators.required]
    })
  }

  regBroker(){
    this.bService.addBroker(this.broForm.value).subscribe(res=>{
      this.router.navigate(['broker/all'])
    }, err=>{
      console.log(err);
    });
  }

}
