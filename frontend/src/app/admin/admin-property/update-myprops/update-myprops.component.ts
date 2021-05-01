import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Property } from 'src/app/property';
import { PropertyServiceService } from 'src/app/property-service.service';

@Component({
  selector: 'app-update-myprops',
  templateUrl: './update-myprops.component.html',
  styleUrls: ['./update-myprops.component.css']
})
export class UpdateMypropsComponentA implements OnInit {
  propid:number;
  prop:Property;

  constructor(private actRouter:ActivatedRoute, private pService:PropertyServiceService, private router:Router) { }

  ngOnInit(): void {
    this.prop=new Property();
    this.propid=this.actRouter.snapshot.params['propid'];
    this.pService.getPropertyById(this.propid).subscribe(data=>{
      this.prop=data;
    })
  }
  updateData(){
    this.pService.updateProperty(this.prop).subscribe(res=>{
      this.router.navigate(['/admin/property/all']);
      alert("Property details updated scuucefully")
    })
  }

}
