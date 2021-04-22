import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrokerComponent } from './broker/broker.component';
import { UpdateComponent } from './broker/update/update.component';

const routes: Routes = [
  { path:'',redirectTo:'broker', pathMatch:'full' },
  {
    path:'broker', component:BrokerComponent,
    children:[
      { path:'update', component:UpdateComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
