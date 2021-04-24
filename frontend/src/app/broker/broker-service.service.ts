import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import {catchError} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class BrokerServiceService {
  private url="http://localhost:8085/real-estate-broker-application/broker"
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  constructor( private httpClient:HttpClient) { }

  addBroker(broker:any):Observable<any[]>{
    return this.httpClient.post<any[]>(this.url+"/add",JSON.stringify(broker),this.httpOptions).pipe(catchError(this.handleError))
  }

  updateBroker(broker:any):Observable<any[]>{
    return this.httpClient.put<any[]>(this.url+"/update",JSON.stringify(broker),this.httpOptions).pipe(catchError(this.handleError))
  }

  getAllBrokers():Observable<any[]>{
    return this.httpClient.get<any[]>(this.url+"/all")
  }

  getBrokerById(id:number):Observable<any>{
    return this.httpClient.get<any>(this.url+"/id/"+id)
  }

  deleteBroker(id:number):Observable<any>{
    return this.httpClient.delete<any>(this.url+"/remove"+"/"+id)
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
