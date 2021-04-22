import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PropertyServiceService } from 'src/app/property-service.service';

@Component({
  selector: 'app-property-search',
  templateUrl: './property-search.component.html',
  styleUrls: ['./property-search.component.css']
})
export class PropertySearchComponent implements OnInit {
  propForm: FormGroup

  constructor( private fb: FormBuilder, private pService:PropertyServiceService,
    private router:Router) { }

  ngOnInit(): void {
    this.propForm=this.fb.group({
      config: ['', Validators.required],
      offer:['', Validators.required],
      city:['', Validators.required],
      minCost:['', Validators.required],
      maxCost:['', Validators.required]
    })
  }

  searchProp() {
    this.pService.getPropertyByCriteria(this.propForm.value).subscribe(res=>{
      this.router.navigate([''])
    }, err=>{
      console.log(err);
    }
    );
    
  }


}
