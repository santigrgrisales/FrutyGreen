package com.fg.project.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Vac_lic;


@Repository
public interface RepositorioVac_lic extends JpaRepository <Vac_lic,Long>{
	


	@Procedure(name="CREARVAC_LIC")
	public void CREARVAC_LIC(@Param("ide")Long identificacion,@Param("tipo") String tipo,@Param("fi") Date fecha_inicio, @Param ("ff")Date fecha_fin);
	
}
