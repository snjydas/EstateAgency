import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrokerComponent } from './broker/broker.component';
import { UpdateComponent } from './broker/update/update.component';
import { AllPropertyByCriteriaComponent } from './customer/all-property-by-criteria/all-property-by-criteria.component';
import { CustomerComponent } from './customer/customer.component';
import { DealComponent } from './customer/deal/deal.component';
import { MyPropertiesComponent } from './customer/my-properties/my-properties.component';
import { PropertySearchComponent } from './customer/property-search/property-search.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
   { path:'',redirectTo:'home', pathMatch:'full' },
   { path: 'home', component:HomeComponent },
  { path: 'login', component:LoginComponent },
  {
    path:'broker', component:BrokerComponent,
    children:[
      { path:'update', component:UpdateComponent}
    ]
  },
  {
    path:'customer',component:CustomerComponent,
    children:[
      {path:'search',component:PropertySearchComponent},
      {path:'criteria',component:AllPropertyByCriteriaComponent},
      {path:'myprops',component:MyPropertiesComponent},
      {path:'update',component:UpdateCustomerComponent},
      {path:'deal/:propid',component:DealComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
