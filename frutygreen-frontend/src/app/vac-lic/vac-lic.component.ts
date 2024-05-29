import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { VacLic } from '../entities/vac-lic';
import { VacLicService } from '../services/vac-lic.service';

@Component({
  selector: 'app-vac-lic',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet],
  templateUrl: './vac-lic.component.html',
  styleUrl: './vac-lic.component.css'
})
export class VacLicComponent implements OnInit{



  constructor(private vacLicService: VacLicService
    
){};  

//Registro de una Licencia 

  vac_lic:VacLic={

    identificacion: null,
    tipo: 'Licencia por',
    fecha_inicio: null,
    fecha_fin: null,

  }

  ngOnInit(): void {

  }

  abrirRegistro(){
  
    const modal= document.getElementById("registroV")
    if(modal!=null)
      modal.style.display='block';

    }
  
    cerrarRegistro(){
  
      const modal =document.getElementById("registroV")
      if(modal!=null)
        modal.style.display ='none';
  
    }
  
    guardarRegistro(){this.vacLicService.registrarVacLic(this.vac_lic).subscribe(dato =>{
  
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
      console.error('Hubo un error al registar el permiso de Licencia', error);
      alert("Hubo un error al registar el permiso de Licencia.\nVerifica la identificacion del empleado");    }); 
  }




 //Registro de un persiso de vacaciones 


 vac_lic2:VacLic={

  identificacion: null,
  tipo: 'Permiso por vacaciones',
  fecha_inicio: null,
  fecha_fin: null,

}



abrirRegistro2(){

  const modal= document.getElementById("registroV2")
  if(modal!=null)
    modal.style.display='block';

  }

  cerrarRegistro2(){

    const modal =document.getElementById("registroV2")
    if(modal!=null)
      modal.style.display ='none';

  }

  guardarRegistro2(){this.vacLicService.registrarVacLic(this.vac_lic2).subscribe(dato =>{

    if(dato!=null){
      alert ("¡Genial! !Nuestro empleado regresa de vacaciones!\nEl registro se realizó correctamente");
      this.cerrarRegistro2();
      console.log(dato);
      window.location.reload();


    }

    else{
      console.log(dato)
      alert("verifica el formulario")
    }
  },error => {
    console.error('Hubo un error al registar el permiso de vacaciones', error);
    alert("Hubo un error al registar el permiso de vacaciones.\nVerifica la identificacion del empleado");    }); 
}
}
