package com.brunocosimano.rnp.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import com.brunocosimano.rnp.commons.ValidationError;
import com.brunocosimano.rnp.entity.Persona;
import com.brunocosimano.rnp.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;

    public void validationPersona(Persona persona) throws ValidationError{
        if (personaRepository.findByDNI(persona.getDNI()) == null) {
            throw new ValidationError("La Persona ya se encuentra cargada");
        }
    }

    public Persona savePersona(Persona persona){
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
