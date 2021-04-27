import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  id:number;
  loginStatus:boolean=false;
  private url="http://localhost:8085/real-estate-broker-application/user"
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  user:string;

  constructor( private httpClient:HttpClient ) { }

  setUser(user:string){
    this.user=user
  }

  getUser(){
    return this.user
  }

  getStatus(){
    return this.loginStatus;
  }

  setStatus(status:boolean){
    this.loginStatus=status;
  }

  setId(id:number){
    this.id=id;
  }

  getId():number{
    return this.id
  }

  login(user:any):Observable<any>{
    return this.httpClient.post<any>(this.url+"/login",JSON.stringify(user),this.httpOptions).pipe(catchError(this.handleError))
  }

  logout(user:any):Observable<any>{
    return this.httpClient.post<any>(this.url+"/logout",JSON.stringify(user),this.httpOptions).pipe(catchError(this.handleError))
  }

  getAllUsers():Observable<any[]>{
    return this.httpClient.get<any[]>(this.url+"/all")
  }

  getUserById(id:number):Observable<any>{
    return this.httpClient.get<any>(this.url+"/id/"+id)
  }

  getUserByEmail(email:string):Observable<any>{
    return this.httpClient.get<any>(this.url+"/email/"+email)
  }

  handleError(eResponse:HttpErrorResponse){
    if(eResponse.error instanceof ErrorEvent){
      console.log("Clinet Side Error ="+eResponse.error.message);
    }
    else{
      console.log("Server Side Error ="+eResponse.error.message)
    }
    return throwError(eResponse.error.message)
  }
}
