package com.fg.project.modelo;

public class Info_personal {
	
	
	
	private Long identificacion;
	
	private String correo;
	
	private String domicilio;
	
	private Long telefono;
	
	
	
	

	public Info_personal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Info_personal(Long identificacion, String correo, String domicilio, Long telefono) {
		super();
		this.identificacion = identificacion;
		this.correo = correo;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
	
   
}
