package com.fg.project.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Pago;
import com.fg.project.modelo.Turno;
import com.fg.project.modelo.Vac_lic;

import java.time.LocalDateTime;
import java.util.List;



@Repository
public interface RepositorioTurno extends JpaRepository <Turno,Long>{
	
	 
		@Procedure(name = "calcularPago")
		public void calcularPago(@Param("ide_empleado") Long identificacion,@Param("he") LocalDateTime hora_entrada, @Param("hs") LocalDateTime hora_salida);
		
		public List<Turno> findByEmpleado(Empleado empleado);
		
		@Query(value="SELECT * FROM turnos WHERE EXTRACT(MONTH FROM hora_salida) = EXTRACT(MONTH FROM SYSDATE)",nativeQuery=true)
		public List<Turno> TurnosUltimoMes();

 
}
