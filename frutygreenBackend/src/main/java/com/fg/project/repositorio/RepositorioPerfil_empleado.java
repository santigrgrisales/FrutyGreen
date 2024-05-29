package com.fg.project.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Info_personal;
import com.fg.project.modelo.Perfil_empleado;
import com.fg.project.modelo.Vac_lic;


@Repository
public interface RepositorioPerfil_empleado extends JpaRepository <Perfil_empleado,Long>{
	
	@Procedure(name="actualizarPerfil")
	public void actualizarPerfil(@Param("ide")Long identificacion, @Param("correo") String correo,@Param("domicilio") String domicilio,@Param("telefono") Long telefono);
    
	
	public Perfil_empleado findByIdentificacion(Long n);

}
