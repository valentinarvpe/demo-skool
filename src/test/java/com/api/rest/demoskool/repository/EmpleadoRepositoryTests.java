package com.api.rest.demoskool.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.api.rest.demoskool.model.entity.Empleado;;

@DataJpaTest
public class EmpleadoRepositoryTests {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@DisplayName("Test para guardar un empleado")
	@Test
	void testGuardarEmpleado() {
		// given -> condición previa o configuracion
		Empleado empleado1 = Empleado.builder().nombre("valen").apellido("rivera").email("valen@sas").build();
		// when -> accion o el comportamiento que vamos a probar
		Empleado empleadoGuardado = empleadoRepository.save(empleado1);

		// then - verificar lo solido
		assertThat(empleadoGuardado).isNotNull();
		assertThat(empleadoGuardado.getId()).isGreaterThan(0);

		// BDD -> SE CENTRA EN EL COMPORTAMIENTO

	}

}
