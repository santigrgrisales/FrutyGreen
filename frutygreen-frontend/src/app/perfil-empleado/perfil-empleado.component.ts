import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { EmpleadoService } from '../services/empleado.service';
import { Empleado } from '../entities/empleado';
import { PerfilEmpleado } from '../entities/perfil-empleado';
import { PerfilEmpleadoService } from '../services/perfil-empleado.service';
import { InfoPersonal } from '../entities/info-personal';

@Component({
  selector: 'app-perfil-empleado',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormsModule],
  templateUrl: './perfil-empleado.component.html', 
  styleUrl: './perfil-empleado.component.css'
})
export class PerfilEmpleadoComponent implements OnInit{

  empleado:Empleado;
  perfilEmpleado:PerfilEmpleado;
  ide:number;
nuevaDescripcion: InfoPersonal=new InfoPersonal;

  vacio:Empleado={
    identificacion: null,
    nombre: '',
    apellidos: '',
    cargo: ''
  };
  perfilVacio:PerfilEmpleado={
    id_perfil: null,
    identificacion: null,
    ultima_evaluacion: '',
    descripcion: ''
  };

  

  constructor(private empleadoServicio: EmpleadoService,
              private perfilEmpleadoServicio: PerfilEmpleadoService
  ){};
  ngOnInit(): void {this.perfilEmpleado=this.perfilVacio;
    this.empleado=this.vacio
    
  }



  debug() {
    console.log("Valor actual en debug:", this.ide);
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

cerrarModal() {
  const modal = document.getElementById("busquedaModal");
  if (modal != null) modal.style.display = 'none';
  this.empleado=this.vacio;
  this.perfilEmpleado=this.perfilVacio;
}

abrirModal() {
  console.log("Modal abierto con identificación:", this.ide);
  const modal = document.getElementById("busquedaModal");

  if (modal != null) modal.style.display = 'block';
  
  this.obtenerEmpleadoBuscado(); 
  this.obtenerPerfil();
}

obtenerPerfil(){this.perfilEmpleadoServicio.obtenerPerfil(this.ide).subscribe(
  dato => {
   
    this.perfilEmpleado=dato;
},
error => {
    console.error("Error al obtener empleado:", error);
}
);
}

// Proceso de actualización

abrirRegistroA(){
  this.nuevaDescripcion.identificacion = this.perfilEmpleado.identificacion;

  const modal= document.getElementById("actualizar")
  if(modal!=null)
    modal.style.display='block';
  
  }

  cerrarRegistroA(){

    const modal =document.getElementById("actualizar")
    if(modal!=null)
      modal.style.display ='none';

  }

  actualizarRegistro(){this.perfilEmpleadoServicio.actualizarEmpleado(this.nuevaDescripcion).subscribe(dato =>{

    if(dato!=null){
      alert ("registro exitoso");
      this.cerrarRegistroA();
      console.log(dato);
      window.location.reload();


    }

    else{
      console.log(dato)
      alert("verifica el formulario")
    }
  },error => {
    console.error('Hubo un error al actualizar', error);
    alert("Hubo un error al actualizar");
  }); 
}

}
