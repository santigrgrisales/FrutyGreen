package com.fg.project.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EVALUACIONES")
public class Evaluacion {
	
	@Id
	@Column(name="id_evaluacion")
	private Long id_evaluacion;
	
	@ManyToOne
	@JoinColumn(name="identificacion", referencedColumnName= "identificacion")
	private Empleado empleado;
	
	@Column(name="descripcion")
	private String descripcion;

	public Evaluacion(Long id_evaluacion, Empleado empleado, String descripcion) {
		this.id_evaluacion = id_evaluacion;
		this.empleado = empleado;
		this.descripcion = descripcion;
	}

	public Evaluacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_evaluacion() {
		return id_evaluacion;
	}

	public void setId_evaluacion(Long id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
