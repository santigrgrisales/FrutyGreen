import { Injectable } from '@angular/core';
import { EnviarPago } from '../entities/enviar-pago';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PagoService {
   BdURL="http://localhost:8080/ver/p/crearPago";
   Bd2URL="http://localhost:8080/ver/p/getPago";
   Bd3URL="http://localhost:8080/ver/p/getPagosTodos";

  
   constructor(private httpClient: HttpClient) { }
  

RegistrarPago(enviarPago: EnviarPago, mes:number): Observable<Object> {
  const url = `${this.BdURL}?mes=${mes}`;
  return this.httpClient.post(url, enviarPago);
}


BuscarPago(): Observable <any>{
  return this.httpClient.get(`${this.Bd2URL}`);
}

BuscarPagosTodos(): Observable <any>{
  return this.httpClient.get(`${this.Bd3URL}`);
}

}