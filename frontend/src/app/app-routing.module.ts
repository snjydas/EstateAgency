import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrokerComponent } from './broker/broker.component';
import { UpdateComponent } from './broker/update/update.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path:'',redirectTo:'login', pathMatch:'full' },
  { path: 'login', component:LoginComponent },
  {
    path:'broker', component:BrokerComponent,
    children:[
      { path:'update/:userId', component:UpdateComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
