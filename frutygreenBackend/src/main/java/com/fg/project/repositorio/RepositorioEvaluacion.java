package com.fg.project.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Evaluacion;
import com.fg.project.modelo.Vac_lic;


@Repository
public interface RepositorioEvaluacion extends JpaRepository <Evaluacion,Long> {

	
	@Procedure(name="ACTUALIZAR_EVALUACION_PERFIL")
	public void ACTUALIZAR_EVALUACION_PERFIL(@Param("IDE") Long identificacion, @Param("DESCRIP") String descripcion);
	
	@Query(value= "SELECT * FROM EVALUACIONES WHERE id_evaluacion = (SELECT MAX(id_evaluacion) FROM EVALUACIONES)", nativeQuery=true)
	public List<Object> ultimaEvaluacion();
}
