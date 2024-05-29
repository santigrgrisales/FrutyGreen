package com.fg.project.modelo;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VAC_LIC")
public class Vac_lic {
	
	@Id
	@Column(name="id_vl")
	private Long id_vl;
	
	
	@Column(name="identificacion")
	private Long identificacion;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name="fecha_fin")
	private Date fecha_fin;

	public Long getId_vl() {
		return id_vl;
	}

	public void setId_vl(Long id_vl) {
		this.id_vl = id_vl;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Vac_lic(Long id_vl, Long identificacion, String tipo, Date fecha_inicio, Date fecha_fin) {
		super();
		this.id_vl = id_vl;
		this.identificacion = identificacion;
		this.tipo = tipo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public Vac_lic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
}
