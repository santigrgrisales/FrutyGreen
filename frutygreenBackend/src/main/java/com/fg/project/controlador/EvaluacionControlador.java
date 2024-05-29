package com.fg.project.controlador;

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
import com.fg.project.modelo.Evaluacion;
import com.fg.project.repositorio.RepositorioEmpleado;
import com.fg.project.repositorio.RepositorioEvaluacion;

@RestController
@RequestMapping("/ver/ev/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EvaluacionControlador {

	
	@Autowired
	private RepositorioEvaluacion repositorioEvaluacion;
	
	@Autowired
	private RepositorioEmpleado repositorioEmpleado;
	
	
	@PostMapping("/crear_evaluacion_actualizar_perfil")
	public Empleado ACTUALIZAR_EVALUACION_PERFIL(@RequestBody Evaluacion evaluacion) {
	 this.repositorioEvaluacion.ACTUALIZAR_EVALUACION_PERFIL(evaluacion.getEmpleado().getIdentificacion(), evaluacion.getDescripcion());
	 return this.repositorioEmpleado.findById(evaluacion.getEmpleado().getIdentificacion()).get();
	}
	
	@GetMapping("/getEvaluacion")
	public ResponseEntity<?> traerEvaluacion() {
	    List<Object> evaluacion = this.repositorioEvaluacion.ultimaEvaluacion();
	    if (!evaluacion.isEmpty()) {
	        return ResponseEntity.ok(evaluacion.get(0)); // Devuelve solo el primer elemento de la lista
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	    
	}
}
	