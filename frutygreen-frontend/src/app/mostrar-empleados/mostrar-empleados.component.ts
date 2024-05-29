import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { Empleado } from '../entities/empleado';
import { EmpleadoService } from '../services/empleado.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-mostrar-empleados',
  standalone: true,
  imports: [RouterOutlet, CommonModule,FormsModule],
  templateUrl: './mostrar-empleados.component.html',
  styleUrl: './mostrar-empleados.component.css'
})
export class MostrarEmpleadosComponent implements OnInit {

  empleados: Empleado[];
  empleado: Empleado = new Empleado;
  

  constructor(private empleadoServicio: EmpleadoService){};
  ngOnInit(): void {

    this.verEmpleados();
  }


  private verEmpleados(){
    this.empleadoServicio.obtenerListaEmpleados().subscribe(dato =>{
      this.empleados = dato;
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
    this.empleadoServicio.registrarEmpleado(this.empleado).subscribe(dato =>{
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
      console.error('Hubo un error al registrar el empleado', error);
      alert("Hubo un error al registrar el empleado");
    }); 
}

}
