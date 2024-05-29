package com.fg.project.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Evaluacion;
import com.fg.project.modelo.Pago;
import com.fg.project.modelo.Perfil_empleado;
import com.fg.project.modelo.Turno;
import com.fg.project.modelo.Vac_lic;
import com.fg.project.repositorio.RepositorioEmpleado;
import com.fg.project.repositorio.RepositorioEvaluacion;
import com.fg.project.repositorio.RepositorioPago;
import com.fg.project.repositorio.RepositorioPerfil_empleado;
import com.fg.project.repositorio.RepositorioTurno;
import com.fg.project.repositorio.RepositorioVac_lic;

import jakarta.transaction.Transactional;



@RestController
@RequestMapping("/ver/e/")
@CrossOrigin(origins = "http://localhost:4200/")

public class EmpleadoControlador {
	
	@Autowired
	private RepositorioEmpleado repositorioEmpleado;

	


//	@PostMapping("/guardarempleados")
//	 public String crearEmpleadoyPerfil(@RequestBody Long ide,String name,String ape,String c){
//		 
//       this.repositorioEmpleado.crearEmpleadoyPerfil(ide, name, ape, c);
//		return "Empleado Creado";
//    }
	
	@PostMapping("/guardarempleados")
	public Empleado crearEmpleadoyPerfil(@RequestBody Empleado empleado){
	    this.repositorioEmpleado.crearEmpleadoyPerfil(empleado.getIdentificacion(), empleado.getNombre(), empleado.getApellidos(), empleado.getCargo());
	    return this.repositorioEmpleado.findById(empleado.getIdentificacion()).get();

	}
	
	
	@GetMapping("/empleados")
	public List<Empleado> verTodosEmpleados(){
		return repositorioEmpleado.findAll();
	 }
	
	
	

	

	
	
	
	@PostMapping("/buscarempleados")
	public ResponseEntity<Empleado> verempleado(@RequestBody Long n) { 
	    Optional<Empleado> empleado = this.repositorioEmpleado.findById(n);
	    if (empleado.isPresent()) {
	        return ResponseEntity.ok(empleado.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}

	 
	 
	 @PostMapping ("/eliminarEmpleado")
	 public Optional eliminarEmpleado(@RequestBody Long n) {
		 
		 this.repositorioEmpleado.eliminarempleado(n);
		 return Optional.empty();
	 }
	 
	 
}	 
	 
//    @Autowired
//	private RepositorioVac_lic repositorioVac_lic;
//	@Autowired
//	private RepositorioTurno repositorioTurno;
//	@Autowired
//	private RepositorioPerfil_empleado repositorioPerfil_empleado;
//	@Autowired
//	private RepositorioPago repositorioPago;
//	@Autowired
//	private RepositorioEvaluacion repositorioEvaluacion;

