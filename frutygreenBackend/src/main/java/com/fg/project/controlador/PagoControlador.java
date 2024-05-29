package com.fg.project.controlador;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Pago;
import com.fg.project.repositorio.RepositorioEmpleado;
import com.fg.project.repositorio.RepositorioPago;

@RestController
@RequestMapping("/ver/p/")
@CrossOrigin(origins = "http://localhost:4200/")
public class PagoControlador {
	
	@Autowired
	private RepositorioPago repositorioPago;
	
	@Autowired
	private RepositorioEmpleado empleadoRepositorio;
	
	
	 @PostMapping("/crearPago")
	 public Empleado crearPago(@RequestBody Pago p,Integer mes){
		 
		    this.repositorioPago.crearPago(p.getEmpleado().getIdentificacion(),mes);
		    return this.empleadoRepositorio.findById(p.getEmpleado().getIdentificacion()).get();
  }
	 
	 
	 @GetMapping("/getPago")
		public ResponseEntity<?> traerPago() {
		    List<Object> pago = this.repositorioPago.ultimoPago();
		    if (!pago.isEmpty()) {
		        return ResponseEntity.ok(pago.get(0)); // Devuelve solo el primer elemento de la lista
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		    
		} 
	 
	 
	 @GetMapping("/getPagosTodos")
	 public List <Pago>mostrarAvg(){
			return this.repositorioPago.PagosUltimoMes();
		}


}
