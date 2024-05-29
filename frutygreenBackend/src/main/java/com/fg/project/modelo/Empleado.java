package com.fg.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado {
	
	@Id
	@Column(name="identificacion")
	private Long identificacion;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="cargo")
	private String cargo;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Empleado(Long identificacion, String nombre, String apellidos, String cargo) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cargo = cargo;
	}
	
	
}
