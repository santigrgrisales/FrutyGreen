import { Empleado } from "./empleado";

export class Turno {

   id_turno:number;
   hora_entrada: Date;
   hora_salida: Date;
   pago: number;
   empleado: Empleado;


   constructor(){
      this.empleado = new Empleado ;
   }
}
