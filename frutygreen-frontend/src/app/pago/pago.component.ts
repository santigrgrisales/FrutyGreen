import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { EnviarPago } from '../entities/enviar-pago';
import { PagoService } from '../services/pago.service';
import { Pago } from '../entities/pago';

@Component({
  selector: 'app-pago',
  standalone: true,
  imports: [RouterOutlet,CommonModule,FormsModule],
  templateUrl: './pago.component.html',
  styleUrl: './pago.component.css'
})
export class PagoComponent implements OnInit{


  ngOnInit(): void {this.mes==null;

    this.buscarRegistrosTodos();


  }
  constructor(private pagoServicio: PagoService){};


  pagor : any[] = [null,null,null,null];
  data:Pago[];







  enviarPago:EnviarPago=new EnviarPago;
  mes:number;

  opcionesMes = [
    { id: 1, nombre: 'Enero' },
    { id: 2, nombre: 'Febrero' },
    { id: 3, nombre: 'Marzo' },
    { id: 4, nombre: 'Abril' },
    { id: 5, nombre: 'Mayo' },
    { id: 6, nombre: 'Junio' },
    { id: 7, nombre: 'Julio' },
    { id: 8, nombre: 'Agosto' },
    { id: 9, nombre: 'Septiembre' },
    { id: 10, nombre: 'Octubre' },
    { id: 11, nombre: 'Noviembre' },
    { id: 12, nombre: 'Diciembre' }
  ];


  debug() {
    console.log("Valor actual en debug:", this.mes);
} 



guardarRegistro(){
  this.pagoServicio.RegistrarPago(this.enviarPago,this.mes).subscribe(dato =>{
    if(dato!=null){
      alert ("registro exitoso");
      console.log(dato);
      this.buscarRegistro();
      this.abrirRegistro();


    }

    else{
      console.log(dato)
      alert("verifica el formulario")
    }
  },error => {
    console.error('Hubo un error al registrar este Pago.', error);
    alert("Hubo un error al registrar este pago.\nVerifica la información");
  }); 
}




buscarRegistro() {
  this.pagoServicio.BuscarPago().subscribe(
    (dato: any) => {
      this.pagor = dato;
      console.log(this.pagor);
      const [variable1,variable2,variable3,variable4] = this.pagor; 
      console.log(variable1);
      console.log(variable2);
      console.log(variable3);
      console.log(variable4);

      
    },
    error => {
      console.error('Error al obtener el pago:', error);
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
  window.location.reload();


}


buscarRegistrosTodos() {
  this.pagoServicio.BuscarPagosTodos().subscribe(
    (dato: any) => {
      
      this.data=dato;
      console.log(this.data)
     
    });
    
}
}




