import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Turno } from '../entities/turno';
import { EnviarTurno } from '../entities/enviar-turno';

@Injectable({
  providedIn: 'root'
})
export class TurnoService {
  
  private bdURL= "http://localhost:8080/ver/t";
  constructor(private httpClient: HttpClient) { }

  obtenerListaTurno(): Observable <any>{
    
    return this.httpClient.get(`${this.bdURL}/getTurnosTodos`);
  }

  RegistrarTurno(turno : EnviarTurno):Observable <Object>{
    return this.httpClient.post(`${this.bdURL}/calcularPago`,turno);
  }
}