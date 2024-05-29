interface EmpleadoIdentificacion {
    identificacion: number | null;
  }
  
  export class EnviarPago{
    empleado: EmpleadoIdentificacion;
    
    
    constructor() {
        this.empleado = { identificacion: null };
        
  }
}