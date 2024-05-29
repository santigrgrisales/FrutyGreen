package com.fg.project.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Pago;
import com.fg.project.modelo.Turno;
import com.fg.project.repositorio.RepositorioEmpleado;
import com.fg.project.repositorio.RepositorioTurno;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/ver/t/")
@CrossOrigin(origins = "http://localhost:4200/")
public class TurnoControlador {

	@Autowired
	private RepositorioTurno repositorioTurno;
	@Autowired
	private RepositorioEmpleado empleadorepositorio;
	
	@GetMapping("/getTurnosTodos")
	 public List <Turno>mostrarAvg(){
			return this.repositorioTurno.TurnosUltimoMes();
		}
	
	 @PostMapping("/calcularPago")
	 public Empleado calcularPago(@RequestBody Turno t){
		 
		    this.repositorioTurno.calcularPago(t.getEmpleado().getIdentificacion(),t.getHora_entrada(),t.getHora_salida());
		    return this.empleadorepositorio.findById(t.getEmpleado().getIdentificacion()).get();
  }
	
}
