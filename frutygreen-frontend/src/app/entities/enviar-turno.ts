

interface EmpleadoIdentificacion {
  identificacion: number | null;
}

export class EnviarTurno {
  empleado: EmpleadoIdentificacion;
  hora_entrada: Date | null;
  hora_salida: Date | null;

  constructor() {
    this.empleado = { identificacion: null };
    this.hora_entrada = null;
    this.hora_salida = null;
  }
}