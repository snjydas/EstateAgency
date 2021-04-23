import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private url="http://localhost:8085/real-estate-broker-application/customer"
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  constructor( private httpClient:HttpClient) { }

  addCustomer(cust:any):Observable<any[]>{
    return this.httpClient.post<any[]>(this.url+"/add",JSON.stringify(cust),this.httpOptions).pipe(catchError(this.handleError))
  }

  updateCustomer(cust:any):Observable<any[]>{
    return this.httpClient.put<any[]>(this.url+"/update",JSON.stringify(cust),this.httpOptions).pipe(catchError(this.handleError))
  }

  getAllCustomers():Observable<any[]>{
    return this.httpClient.get<any[]>(this.url+"/all")
  }

  getAllProperties(id:number):Observable<any[]>{
    return this.httpClient.get<any[]>(this.url+"/properties/"+id)
  }

  getCustomerById(id:number):Observable<any>{
    return this.httpClient.get<any>(this.url+"/id/"+id)
  }

  deleteCustomer(id:number):Observable<any>{
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
