import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:9090/api/employee';
  //private baseUrl = 'http://api:9090/api/employee';

  constructor(private http: HttpClient) { }

  getEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/find/${id}`);
  }

  createRandomEmployee(): Observable<any> {
    return this.http.get(`${this.baseUrl}/create-random`);
  }

  createEmployee(employee: Object): Observable<Object> {
    console.log('/create: '+JSON.stringify(employee))
    return this.http.post(`${this.baseUrl}/create`, employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }
}