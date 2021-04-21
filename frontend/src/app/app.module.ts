import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrokerComponent } from './broker/broker.component';
import { CustomerComponent } from './customer/customer.component';
import { AddPropertyComponent } from './add-property/add-property.component';
import { UpdateBrokerComponent } from './update-broker/update-broker.component';
import { BrokerPropertiesComponent } from './broker-properties/broker-properties.component';
import { SignupComponent } from './signup/signup.component';
import { CustomerPropertiesComponent } from './customer-properties/customer-properties.component';
import { AllPropertiesComponent } from './all-properties/all-properties.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { DealComponent } from './deal/deal.component';
import { PropertySearchComponent } from './property-search/property-search.component';
import { PropertyListByCriteriaComponent } from './property-list-by-criteria/property-list-by-criteria.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BrokerComponent,
    CustomerComponent,
    AddPropertyComponent,
    UpdateBrokerComponent,
    BrokerPropertiesComponent,
    SignupComponent,
    CustomerPropertiesComponent,
    AllPropertiesComponent,
    UpdateCustomerComponent,
    DealComponent,
    PropertySearchComponent,
    PropertyListByCriteriaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
