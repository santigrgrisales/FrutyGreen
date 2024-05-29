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
import com.fg.project.modelo.Info_personal;
import com.fg.project.modelo.Perfil_empleado;
import com.fg.project.modelo.Vac_lic;
import com.fg.project.repositorio.RepositorioEmpleado;
import com.fg.project.repositorio.RepositorioPerfil_empleado;

@RestController
@RequestMapping("/ver/pe/")
@CrossOrigin(origins = "http://localhost:4200/")
public class Perfil_empleadoControlador {
	
	@Autowired 
	private RepositorioPerfil_empleado repositorioPerfil_empleado;
	
	 @Autowired 
	private RepositorioEmpleado repositorioempleado;
	
	@PostMapping("/info_perfil")
	public Empleado actualizarPerfil(@RequestBody Info_personal ip) {
		this.repositorioPerfil_empleado.actualizarPerfil(ip.getIdentificacion(),ip.getCorreo(),ip.getDomicilio(),ip.getTelefono());
	return this.repositorioempleado.findById(ip.getIdentificacion()).get();	}
    
	@PostMapping("/buscarempleadosPerfil")
	private Perfil_empleado perfilByIdentificacion(@RequestBody Long n){
		return this.repositorioPerfil_empleado.findByIdentificacion(n);
	}
	
	
//	 @PostMapping("/buscarempleadosPerfil")
//	 public ResponseEntity<Perfil_empleado> verPerfil(@RequestBody Empleado n) { 
//		    Optional<Perfil_empleado> perfil = this.repositorioPerfil_empleado.findByEmpleado(n);
//		    if (perfil.isPresent()) {
//		        return ResponseEntity.ok(perfil.get());
//		    } else {
//		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		    }
//		}
}
