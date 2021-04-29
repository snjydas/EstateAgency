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
  alert:boolean

  constructor( private fb: FormBuilder, private pService:PropertyServiceService,
    private router:Router) { }
    
  ngOnInit(): void {
    this.propForm=this.fb.group({
      config: [''],
      offer:[''],
      city:[''],
      minCost:['', [Validators.required, Validators.pattern("[0-9]{2,}")]],
      maxCost:['', [Validators.required, Validators.pattern("[0-9]{3,}")]]
    })
  }

  get config(){
    return this.propForm.get('config');
  }

  get offer(){
    return this.propForm.get('offer');
  }

  get city(){
    return this.propForm.get('city');
  }

  get minCost(){
    return this.propForm.get('minCost');
  }

  get maxCost(){
    return this.propForm.get('maxCost');
  }

  searchProp() {
    if(this.propForm.value.minCost!="" && this.propForm.value.maxCost!="" && this.propForm.value.minCost>this.propForm.value.maxCost){
      this.alert=true;
    }
    else{
      this.pService.setCriteria(this.propForm.value)
      this.router.navigate(['/customer/criteria'])
    }
    // this.pService.setCriteria(this.propForm.value)
    // this.router.navigate(['/customer/criteria'])
    
  }

}
