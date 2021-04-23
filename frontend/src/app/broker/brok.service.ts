import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, pipe, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Property } from '../property';
import { Broker } from './broker';

@Injectable({
  providedIn: 'root'
})
export class BrokService {

  private url="http://localhost:8085/real-estate-broker-application/broker";
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  constructor(private httpClient:HttpClient) { }

  addBroker(bro:Broker): Observable<Broker[]>{
    return this.httpClient.post<Broker[]>(this.url+"/add",JSON.stringify(bro),this.httpOptions).pipe(catchError(this.handleError));
  }
  updateBroker(broker:Broker):Observable<Broker[]>{
    return this.httpClient.put<Broker[]>(this.url+"/update",JSON.stringify(broker),this.httpOptions).pipe(catchError(this.handleError));
  }
  getAllBroker():Observable<Broker[]>{
    return this.httpClient.get<Broker[]>(this.url+"/all").pipe(catchError(this.handleError));
  }
  getBrokerById(broid:number):Observable<Broker>{
    return this.httpClient.get<Broker>(this.url+"/id/"+broid);
  }
  deleteBroker(broid:number):Observable<Broker[]>{
    return this.httpClient.delete<Broker[]>(this.url+"/remove/"+broid).pipe(catchError(this.handleError));
  }
  getProperties(broid:number):Observable<Property[]>{
    return this.httpClient.get<Property[]>(this.url+"/properties/"+broid).pipe(catchError(this.handleError));
  }
  handleError(eResponse:HttpErrorResponse){
    if(eResponse.error instanceof ErrorEvent){
      console.log("Client Side Error ="+eResponse.error.message);
    }
    else{
      console.log("Server Side Error ="+eResponse.error.message);
    }
    return throwError(eResponse.error.message);
  }
}
