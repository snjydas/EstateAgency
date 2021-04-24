import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrokerComponent } from './broker/broker.component';
import { CustomerComponent } from './customer/customer.component';
import { SignupComponent } from './signup/signup.component';
import { PropertySearchComponent } from './customer/property-search/property-search.component';
import { UpdateComponent } from './broker/update/update.component';
import { APP_BASE_HREF } from '@angular/common';
import { MyPropertiesComponent } from './customer/my-properties/my-properties.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { AvailablePropPipe } from './available-prop.pipe';
import { OfferPipe } from './offer.pipe';
import { DealComponent } from './customer/deal/deal.component';
import { AllPropertyByCriteriaComponent } from './customer/all-property-by-criteria/all-property-by-criteria.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BrokerComponent,
    CustomerComponent,
    SignupComponent,
    PropertySearchComponent,
    UpdateComponent,
    MyPropertiesComponent,
    AllPropertyByCriteriaComponent,
    UpdateCustomerComponent,
    AvailablePropPipe,
    OfferPipe,
    DealComponent,
    HomeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{provide: APP_BASE_HREF, useValue : '/' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
