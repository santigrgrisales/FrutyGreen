package com.fg.project.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Vac_lic;

@Repository	
public interface RepositorioEmpleado extends JpaRepository <Empleado,Long>{
			

    
	@Procedure(name = "crearEmpleadoyPerfil")
	public void crearEmpleadoyPerfil(@Param("ide") Long ide,@Param("name")String name,@Param("ape")String ape,@Param("c")String c);
	
	
	
	@Procedure(name="eliminarempleado")
	public void eliminarempleado(@Param("ide")Long ide);
	
}	
	
	
	
	
	



