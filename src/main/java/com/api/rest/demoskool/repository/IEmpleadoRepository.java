package com.api.rest.demoskool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.demoskool.model.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	Optional<Empleado> findByEmail(String email);
}
