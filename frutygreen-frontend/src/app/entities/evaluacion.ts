import { Empleado } from './empleado';


export class Evaluacion {
    id_evaluacion : number;
    empleado : Empleado;
    descripcion : string;
    

    constructor(){
        this.empleado = new Empleado ;
     }
}