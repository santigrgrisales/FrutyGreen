package com.fg.project.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fg.project.modelo.Pago;

@Repository
public interface RepositorioPago extends JpaRepository <Pago,Long> {

	
	@Procedure(name = "crearPago")
	public void crearPago(@Param("ide") Long identificacion,@Param("var_mes") int mes);
	
	
	@Query(value= "SELECT * FROM Pagos WHERE id_pago = (SELECT MAX(id_pago) FROM pagos)", nativeQuery=true)
	public List<Object> ultimoPago();
	
	
	@Query(value="SELECT id_pago,identificacion,salario,mes FROM pagos WHERE mes = EXTRACT(MONTH FROM SYSDATE)",nativeQuery=true)
	public List<Pago> PagosUltimoMes();
}
