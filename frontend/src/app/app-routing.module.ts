import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllBrokersComponent } from './broker/all-brokers/all-brokers.component';
import { BrokerComponent } from './broker/broker.component';
import { CreateComponent } from './broker/create/create.component';
import { MyPropertiesComponentB } from './broker/my-properties/my-properties.component';
import { UpdateMypropsComponent } from './broker/update-myprops/update-myprops.component';
import { UpdateUserComponent } from './broker/update-user/update-user.component';
import { UpdateComponent } from './broker/update/update.component';
import { AllPropertyByCriteriaComponent } from './customer/all-property-by-criteria/all-property-by-criteria.component';
import { CustomerComponent } from './customer/customer.component';
import { DealComponent } from './customer/deal/deal.component';
import { MyPropertiesComponent } from './customer/my-properties/my-properties.component';
import { PropertySearchComponent } from './customer/property-search/property-search.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path:'',redirectTo:'login', pathMatch:'full' },
  { path: 'login', component:LoginComponent },
  {
    path:'broker', component:BrokerComponent,
    children: [
      { path: 'update/:userid', component:UpdateComponent},
      { path: 'all', component:AllBrokersComponent},
      { path: 'add', component:CreateComponent},
      { path:'myprops', component:MyPropertiesComponentB},
      {path:'updating/:propid',component:UpdateMypropsComponent},
      { path: 'updateuser/:userid', component:UpdateUserComponent}
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
