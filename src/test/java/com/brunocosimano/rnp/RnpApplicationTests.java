package com.brunocosimano.rnp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.brunocosimano.rnp.commons.EnumGenero;
import com.brunocosimano.rnp.controller.PersonaController;
import com.brunocosimano.rnp.entity.Persona;
import com.brunocosimano.rnp.repository.PersonaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RnpApplicationTests {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	PersonaController personaController;

	@Test
	void test() {
		Persona p = new Persona();
		p.setNombre("Maite");
		p.setApellido("Oviedo");
		p.setDNI(12456789);
		p.setSexo(EnumGenero.MASCULINO);
		personaRepository.save(p);
		assertNotNull(personaRepository.findById(1).get());
		assertNotNull(personaRepository.findByApellido("Ovi"));
		assertNotNull(personaRepository.findByDni(38760224));

		
		assertNotNull(personaController.buscaPersonaID(1));
		assertNotNull(personaController.buscarPorApellido("Ovi"));
		assertNotNull(personaController.modifyPersona(p, 1));
		
		
	}

}
