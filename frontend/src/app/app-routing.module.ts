import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminBrokerComponent } from './admin/admin-broker/admin-broker.component';
import { UpdatebrokerDetailsComponent } from './admin/admin-broker/updatebroker-details/updatebroker-details.component';
import { AddCustomerComponent } from './admin/admin-customer/add-customer/add-customer.component';
import { AdminCustomerComponent } from './admin/admin-customer/admin-customer.component';
import { UpdatecustomerDetailsComponent } from './admin/admin-customer/updatecustomer-details/updatecustomer-details.component';
import { AdminDealComponent } from './admin/admin-deal/admin-deal.component';
import { AdminPropertyComponent } from './admin/admin-property/admin-property.component';
import { UpdateMypropsComponentA } from './admin/admin-property/update-myprops/update-myprops.component';
import { AdminComponent } from './admin/admin.component';
import { AllPropertiesComponent } from './all-properties/all-properties.component';
import { AllBrokersComponent } from './broker/all-brokers/all-brokers.component';
import { BrokerComponent } from './broker/broker.component';
import { CreatePropertiesComponent } from './broker/create-properties/create-properties.component';
import { CreateComponent } from './broker/create/create.component';
import { MyPropertiesComponentB } from './broker/my-properties/my-properties.component';
import { UpdateMypropsComponent } from './broker/update-myprops/update-myprops.component';
import { UpdateUserComponent } from './broker/update-user/update-user.component';
import { UpdateComponent } from './broker/update/update.component';
import { AllCustomersComponent } from './customer/all-customers/all-customers.component';
import { AllPropertyByCriteriaComponent } from './customer/all-property-by-criteria/all-property-by-criteria.component';
import { CustomerComponent } from './customer/customer.component';
import { DealComponent } from './customer/deal/deal.component';
import { MyPropertiesComponent } from './customer/my-properties/my-properties.component';
import { PropertySearchComponent } from './customer/property-search/property-search.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { DevelopersComponent } from './developers/developers.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [
   { path:'',redirectTo:'home', pathMatch:'full' },
   { path: 'home', component:HomeComponent },
  { path: 'login', component:LoginComponent },
  { path: 'developers', component:DevelopersComponent },
  { path: 'signup', component:SignupComponent },
  {
    path:'broker', component:BrokerComponent,
    children: [
      { path: 'update/:userid', component:UpdateComponent},
      { path: 'all', component:AllBrokersComponent},
      { path: 'add', component:CreateComponent},
      { path:'myprops', component:MyPropertiesComponentB},
      {path:'updating/:propid',component:UpdateMypropsComponent},
      { path: 'updateuser', component:UpdateUserComponent},
      { path: 'create', component:CreatePropertiesComponent}
    ]

  },
  {
    path:'admin', component:AdminComponent,
    children:[
      {path:'broker', component:AdminBrokerComponent, 
        children:[
          {path:'all', component:AllBrokersComponent},
          {path:'add', component:CreateComponent},
          { path: 'update/:userid', component:UpdatebrokerDetailsComponent},
        ]},
      {path:'customer', component:AdminCustomerComponent,
        children:[
          {path:'all', component:AllCustomersComponent},
          {path: 'update/:userid', component:UpdatecustomerDetailsComponent},
          {path: 'add', component: AddCustomerComponent}
        ]  
      },
      {path:'deal', component:AdminDealComponent},
      {path:'property', component:AdminPropertyComponent,
        children:[
          {path:'all', component:AllPropertiesComponent},
          {path:'updating/:propid',component:UpdateMypropsComponentA}
        ]
      }
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
