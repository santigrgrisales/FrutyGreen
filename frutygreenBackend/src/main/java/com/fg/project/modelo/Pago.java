package com.fg.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PAGOS")
public class Pago {
	
	@Id
	@Column(name="id_pago")
	private Long id_pago;
	
	
	@ManyToOne
	@JoinColumn(name="identificacion", referencedColumnName="identificacion")
	private Empleado empleado;
	
	@Column(name="salario")
	private double salario;
	
	@Column(name="mes")
	private String mes;
	
	
	
	

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(Long id_pago, Empleado empleado, double salario, String mes) {
		super();
		this.id_pago = id_pago;
		this.empleado = empleado;
		this.salario = salario;
		this.mes = mes;
	}

	public Long getId_pago() {
		return id_pago;
	}

	public void setId_pago(Long id_pago) {
		this.id_pago = id_pago;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	
	
	
}

