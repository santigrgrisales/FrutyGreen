import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VacLic } from '../entities/vac-lic';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VacLicService {


  private bdURL="http://localhost:8080/ver/vl/crearVac_lic";

  constructor(private httpClient: HttpClient) { }


  registrarVacLic(VacLic:VacLic):Observable <any>{
    console.log(VacLic);
    return this.httpClient.post(`${this.bdURL}`,VacLic);
  }
}
