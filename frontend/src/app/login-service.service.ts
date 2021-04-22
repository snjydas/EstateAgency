import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  users:User[]=[
    new User("Admin", "groupE")
  ]
  private isLoginStatus:boolean=false;

  constructor() { }

  getLoginStatus(){
    return this.isLoginStatus;
  }
  setLoginStatus(status:boolean){
    this.isLoginStatus=status;
  }
  validateLogin(data:any):boolean{
    for(let u of this.users)
    {
      if(u.uname===data.uname && u.password==data.password){
        return true;
      }
    }
    return false;
  }
}
