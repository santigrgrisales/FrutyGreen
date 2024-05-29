import { Empleado } from './../entities/empleado';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Turno } from '../entities/turno';
import { TurnoService } from '../services/turno.service';
import { EmpleadoComponent } from '../empleado/empleado.component';
import { EnviarTurno } from '../entities/enviar-turno';

@Component({
  selector: 'app-turno',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule,EmpleadoComponent],
  templateUrl: './turno.component.html',
  styleUrl: './turno.component.css'
})
export class TurnoComponent {
  turnos: Turno[];
  turno: EnviarTurno=new EnviarTurno;
  

  constructor(private turnoServicio: TurnoService){};
  ngOnInit(): void {

    this.verTurnos();
  }


  private verTurnos(){
    this.turnoServicio.obtenerListaTurno().subscribe(dato =>{
      this.turnos = dato;
    })
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
    this.turnoServicio.RegistrarTurno(this.turno).subscribe(dato =>{
      if(dato!=null){
        alert ("registro exitoso");
        this.cerrarRegistro();
        console.log(dato);
        window.location.reload();


      }

      else{
        console.log(dato)
        alert("verifica el formulario")
      }
    },error => {
      console.error('Hubo un error al registrar este turno.', error);
      alert("Hubo un error al registrar este turno.\nVerifica la información");
    }); 
}
}