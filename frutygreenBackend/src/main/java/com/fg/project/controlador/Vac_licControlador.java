package com.fg.project.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fg.project.modelo.Empleado;
import com.fg.project.modelo.Vac_lic;
import com.fg.project.repositorio.RepositorioEmpleado;
import com.fg.project.repositorio.RepositorioVac_lic;

@RestController
@RequestMapping("/ver/vl/")
@CrossOrigin(origins = "http://localhost:4200/")
public class Vac_licControlador {
	
	@Autowired
	private RepositorioVac_lic repositorioVac_lic;
	
	@Autowired
	private RepositorioEmpleado empleadorepositorio;
	
	
	@PostMapping("/crearVac_lic")
	private Empleado crearVac_lic(@RequestBody Vac_lic n){
		
		this.repositorioVac_lic.CREARVAC_LIC(n.getIdentificacion(),n.getTipo(),n.getFecha_inicio(),n.getFecha_fin());
		return this.empleadorepositorio.findById(n.getIdentificacion()).get();
	}

	
}
