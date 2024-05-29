interface EmpleadoIdentificacion {
    identificacion: number | null;
  }
  
  export class EnviarEvaluacion {
    empleado: EmpleadoIdentificacion;
    
    descripcion : string | null;
  
    constructor() {
      this.empleado = { identificacion: null };
      this.descripcion = null;
    }
  }