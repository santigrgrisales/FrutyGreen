import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Empleado } from '../entities/empleado';
import { BrowserModule } from '@angular/platform-browser';
import { EmpleadoService } from '../services/empleado.service';

@Component({
  selector: 'app-empleado-delete',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormsModule],
  templateUrl: './empleado-delete.component.html',
  styleUrl: './empleado-delete.component.css'
})
export class EmpleadoDeleteComponent implements OnInit {

  ngOnInit(): void {
this.empleado=this.limpiar;
    
  }
    ide: number;
    empleado: Empleado;
    
    limpiar: Empleado = {
      identificacion: null,
      nombre: '',
      apellidos: '',
      cargo: ''
    };

    

    constructor(private empleadoServicio: EmpleadoService) {}

    debug() {
        console.log("Valor actual en debug:", this.ide);
    }  

    cerrarModal() {
        const modal = document.getElementById("busquedaModal");
        if (modal != null) modal.style.display = 'none';
        this.empleado=this.limpiar;
    }

    abrirModal() {
        console.log("Modal abierto con identificación:", this.ide);
        const modal = document.getElementById("busquedaModal");
        if (modal != null) modal.style.display = 'block';
        
        this.obtenerEmpleadoBuscado(); 
    }

    obtenerEmpleadoBuscado() {
        this.empleadoServicio.obtenerEmpleado(this.ide).subscribe(
            dato => {
                console.log(dato);
                this.empleado = dato;
            },
            error => {
                console.error("Error al obtener empleado:", error);
            }
        );
    }


    eliminarEmpleado(){
      this.empleadoServicio.eliminarEmpleado(this.ide).subscribe(
        dato=>{
          alert ("Empleado eliminado");
        this.cerrarModal();
        }
      );
    }
}

