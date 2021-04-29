import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PropertyServiceService {
  private url = "http://localhost:8085/real-estate-broker-application/property"
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  private criteria = { config: "", offer: "", city: "", minCost: "", maxCost: "" };
  constructor(private httpClient: HttpClient) { }

  setCriteria(criteria: any) {
    this.criteria = criteria;
  }
  getCriteria(): any {
    return this.criteria;
  }
  addProperty(property: any): Observable<any[]> {
    return this.httpClient.post<any[]>(this.url + "/add", JSON.stringify(property), this.httpOptions).pipe(catchError(this.handleError))
  }

  updateProperty(property: any): Observable<any[]> {
    return this.httpClient.put<any[]>(this.url + "/update", JSON.stringify(property), this.httpOptions).pipe(catchError(this.handleError))
  }

  getAllProperties(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.url + "/all")
  }

  getPropertyById(id: number): Observable<any> {
    return this.httpClient.get<any>(this.url + "/id/" + id)
  }

  getPropertyByCriteria(criteria: any): Observable<any[]> {
    return this.httpClient.post<any[]>(this.url + "/criteria", JSON.stringify(criteria), this.httpOptions).pipe(catchError(this.handleError))
  }

  deleteProperty(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.url + "/remove" + "/" + id)
  }

  handleError(eResponse: HttpErrorResponse) {
    if (eResponse.error instanceof ErrorEvent) {
      console.log("Client Side Error =" + eResponse.error.message);
    }
    else {
      console.log("Server Side Error =" + eResponse.error.message)
    }
    return throwError(eResponse.error.message)
  }
}
