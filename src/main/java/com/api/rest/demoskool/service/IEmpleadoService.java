package com.api.rest.demoskool.service;

import java.util.List;
import java.util.Optional;

import com.api.rest.demoskool.model.entity.Empleado;

public interface IEmpleadoService {

	Empleado saveEmpleado(Empleado empleado);

	List<Empleado> getAllEmpleados();

	Optional<Empleado> getEmpleadoById(long id);

	Empleado updateEmpleado(Empleado empleadoActualizado);

	void deleteEmpleado(long id);
}
