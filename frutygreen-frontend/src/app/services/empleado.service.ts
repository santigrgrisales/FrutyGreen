import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from '../entities/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private bdURL= "http://localhost:8080/ver/e";
  private bd2URL= "http://localhost:8080/ver/e/guardarempleados";
  private bd3URL= "http://localhost:8080/ver/e/buscarempleados";
  private bd4URL= "http://localhost:8080/ver/e/eliminarEmpleado";


  constructor(private httpClient: HttpClient) { }

  obtenerListaEmpleados(): Observable <any>{
    
    return this.httpClient.get(`${this.bdURL}/empleados`);
  }

  registrarEmpleado(empleado:Empleado):Observable <Object>{
    console.log(empleado);
    return this.httpClient.post(`${this.bd2URL}`,empleado);
  }

  obtenerEmpleado(identificacion:number):Observable<any>{
    console.log(identificacion)
    return this.httpClient.post(`${this.bd3URL}`,identificacion);

  }

  eliminarEmpleado(identificacion:number):Observable<any>{
   return this.httpClient.post(`${this.bd4URL}`,identificacion)

  }

}
