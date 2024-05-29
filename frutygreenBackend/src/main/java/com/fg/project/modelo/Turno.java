package com.fg.project.modelo;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TURNOS")
public class Turno {
	
	@Id
	@Column(name="id_turno")
	private Long id_turno;
	
	@Column(name="hora_entrada")
	private LocalDateTime hora_entrada;
	
	@Column(name="hora_salida")
	private LocalDateTime hora_salida;
	
	@Column(name="pago")
	private Double pago;
	
	@ManyToOne
	@JoinColumn(name="identificacion", referencedColumnName="identificacion")
	private Empleado empleado;
	
	
	
	
	

	public Turno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turno(Long id_turno, LocalDateTime hora_entrada, LocalDateTime hora_salida, Double pago, Empleado empleado) {
		super();
		this.id_turno = id_turno;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.pago = pago;
		this.empleado = empleado;
	}

	public Long getId_turno() {
		return id_turno;
	}

	public void setId_turno(Long id_turno) {
		this.id_turno = id_turno;
	}

	public LocalDateTime getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(LocalDateTime hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public LocalDateTime getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(LocalDateTime hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Double getPago() {
		return pago;
	}

	public void setPago(Double pago) {
		this.pago = pago;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
	
}
