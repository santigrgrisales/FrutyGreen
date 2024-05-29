package com.fg.project.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PERFIL_EMPLEADOS")
public class Perfil_empleado {
	
	@Id
	@Column(name="id_perfil")
	private Long id_perfil;
	
	
	@Column(name="identificacion")
	private Long identificacion;
	
	
	@Column(name="ultima_evaluacion")
	private String ultima_evaluacion;
	
	@Column(name="descripcion")
	private String descripcion;

	public Long getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Long id_perfil) {
		this.id_perfil = id_perfil;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getUltima_evaluacion() {
		return ultima_evaluacion;
	}

	public void setUltima_evaluacion(String ultima_evaluacion) {
		this.ultima_evaluacion = ultima_evaluacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Perfil_empleado(Long id_perfil, Long identificacion, String ultima_evaluacion, String descripcion) {
		super();
		this.id_perfil = id_perfil;
		this.identificacion = identificacion;
		this.ultima_evaluacion = ultima_evaluacion;
		this.descripcion = descripcion;
	}

	public Perfil_empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
