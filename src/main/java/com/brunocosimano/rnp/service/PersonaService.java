package com.brunocosimano.rnp.service;

import java.util.ArrayList;
import java.util.Optional;
import com.brunocosimano.rnp.entity.Persona;
import com.brunocosimano.rnp.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;

    public Persona savePersona(Persona persona){
        for (Persona persona2 : personaRepository.findByDni(persona.getDni())) {
            if (persona2.getDni() == persona.getDni() ) {
                return persona;
            }
        }
        return personaRepository.save(persona);
    }

    public Persona modifyPersona(Persona persona){
        return personaRepository.save(persona);        
    }

    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id);
    }

    public ArrayList<Persona> findByApellido(String apellido){
        return personaRepository.findByApellido(apellido);
    }

}
