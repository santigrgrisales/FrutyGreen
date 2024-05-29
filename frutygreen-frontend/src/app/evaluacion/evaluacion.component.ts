import { Evaluacion } from './../entities/evaluacion';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EvaluacionService } from '../services/evaluacion.service';
import { EnviarEvaluacion } from '../entities/enviar-evaluacion';

@Component({
  selector: 'app-evaluacion',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule, RouterOutlet],
  templateUrl: './evaluacion.component.html',
  styleUrl: './evaluacion.component.css'
})
export class EvaluacionComponent {
  evaluacion: EnviarEvaluacion = new EnviarEvaluacion;
  evaluacionr : any[] = [null,null,null];
  constructor(private evaluacionServicio: EvaluacionService){};

  buscarRegistro() {
    this.evaluacionServicio.BuscarEvaluacion().subscribe(
      (dato: any) => {
        this.evaluacionr = dato;
        console.log(this.evaluacionr);
        const [variable1,variable2,variable3] = this.evaluacionr; 
        console.log(variable1);
        
      },
      error => {
        console.error('Error al obtener la evaluación:', error);
      }
    );
  }

abrirRegistro(){

  const modal =document.getElementById("registro")
  if(modal!=null)
    modal.style.display ='block';
  
  
}

cerrarRegistro(){

  const modal =document.getElementById("registro")
  if(modal!=null)
    modal.style.display ='none';

}


guardarRegistro(){
  this.evaluacionServicio.RegistrarEvaluacion(this.evaluacion).subscribe(dato =>{
    if(dato!=null){
      this.buscarRegistro();
      this.abrirRegistro();
      
    }

    else{
      alert("verifica el formulario")
    }
  },error => {
    console.error('Hubo un error al registrar esta evaluacion.', error);
    alert("Hubo un error al registrar este evaluacion.\nVerifica la información");
  }); 
}
}