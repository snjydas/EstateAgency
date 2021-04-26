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
      config: [''],
      offer:[''],
      city:[''],
      minCost:[''],
      maxCost:['']
    })
  }

  searchProp() {
    this.pService.setCriteria(this.propForm.value)
    this.router.navigate(['/customer/criteria'])
  }

}
