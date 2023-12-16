package com.api.rest.demoskool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.rest.demoskool.model.entity.Empleado;
import com.api.rest.demoskool.service.IEmpleadoService;


public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.saveEmpleado(empleado);
	}
	
	@GetMapping
	public List<Empleado> listarEmpleados(){
		return empleadoService.getAllEmpleados();
	}
	
	@GetMapping	
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") long id) {
		return empleadoService.getEmpleadoById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("id") long empleadoId, 
			@RequestBody Empleado empleado){
		return empleadoService.getEmpleadoById(empleadoId)
				.map(empleadoGuardado -> {
					empleadoGuardado.setNombre(empleado.getNombre());
					empleadoGuardado.setEmail(empleado.getEmail());
				
					Empleado empleadoActualizado = empleadoService.updateEmpleado(empleado);
					return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") long empleadoId){
		empleadoService.deleteEmpleado(empleadoId);
		return new ResponseEntity<String>("Empleado eliminado exitosamente", HttpStatus.OK);
	}
}
