package com.api.rest.demoskool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.rest.demoskool.exception.ResourceNotFoundException;
import com.api.rest.demoskool.model.entity.Empleado;
import com.api.rest.demoskool.repository.IEmpleadoRepository;

public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	

	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		Optional<Empleado> empleadoGuardado = empleadoRepository.findByEmail(empleado.getEmail());
		if (empleadoGuardado.isPresent()) {
			throw new ResourceNotFoundException("El empleado con ese email ya existe: "+ empleado.getEmail());
		}
		return empleadoRepository.save(empleado);
	}

	@Override
	public Optional<Empleado> getEmpleadoById(long id) {
		return empleadoRepository.findById(id);
	}

	@Override
	public Empleado updateEmpleado(Empleado empleadoActualizado) {
		return empleadoRepository.save(empleadoActualizado);
	}

	@Override
	public void deleteEmpleado(long id) {
		empleadoRepository.deleteById(id);
		
	}
}
