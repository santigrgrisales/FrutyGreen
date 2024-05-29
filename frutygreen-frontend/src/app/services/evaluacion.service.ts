import { Evaluacion } from './../entities/evaluacion';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EnviarEvaluacion } from '../entities/enviar-evaluacion';

@Injectable({
  providedIn: 'root'
})
export class EvaluacionService {

  private bdURL= "http://localhost:8080/ver/ev";
  constructor(private httpClient: HttpClient) { }

  RegistrarEvaluacion(evaluacion: EnviarEvaluacion):Observable <Object>{
    return this.httpClient.post(`${this.bdURL}/crear_evaluacion_actualizar_perfil`,evaluacion);
  }

  BuscarEvaluacion(): Observable <any>{
    return this.httpClient.get(`${this.bdURL}/getEvaluacion`);
  }
}