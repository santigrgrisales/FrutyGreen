import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InfoPersonal } from '../entities/info-personal';

@Injectable({
  providedIn: 'root'
})
export class PerfilEmpleadoService {

  private bd4URL="http://localhost:8080/ver/pe/buscarempleadosPerfil";
  private bd5URL="http://localhost:8080/ver/pe/info_perfil";

  constructor(private httpClient: HttpClient) { }

 obtenerPerfil(identificacion:number):Observable<any>{
  console.log(identificacion);
  return this.httpClient.post(`${this.bd4URL}`,identificacion);
}

actualizarEmpleado(nuevaDescripcion:InfoPersonal):Observable<any>{
  console.log(nuevaDescripcion);
  return this.httpClient.post(`${this.bd5URL}`,nuevaDescripcion);

  

}

}
