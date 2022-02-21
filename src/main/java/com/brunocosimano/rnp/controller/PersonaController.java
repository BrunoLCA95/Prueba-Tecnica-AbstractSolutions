package com.brunocosimano.rnp.controller;

import java.util.ArrayList;
import java.util.Optional;
import com.brunocosimano.rnp.entity.Persona;
import com.brunocosimano.rnp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping(path = "/{id}")
    public Optional<Persona> buscaPersonaID(@PathVariable("id") Integer id){
        return personaService.findById(id);
    }

    @GetMapping("search/{apellido}")
    public ArrayList<Persona> buscarPorApellido(@PathVariable("apellido") String apellido){
        return personaService.findByApellido(apellido);
    }

    @PostMapping
    public ResponseEntity<?> savePersona(@RequestBody Persona persona){
        try {
            personaService.savePersona(persona);
            return new ResponseEntity<Persona>(persona, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<Persona>(persona, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modifyPersona(@RequestBody Persona persona, @PathVariable("id") Integer id){
        Persona personaM = personaService.findById(id).get();
        try {
            personaM.setSexo(persona.getSexo());
            personaService.modifyPersona(personaM);  
            return new ResponseEntity<Persona>(personaM, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<Persona>(personaM, HttpStatus.BAD_REQUEST);
        }
    }
}
