package com.brunocosimano.rnp.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.brunocosimano.rnp.entity.Persona;
import com.brunocosimano.rnp.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Persona savePersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
    }

    @PatchMapping(path = "genero/")
    public Persona modifyPersona(@RequestBody Persona persona){
        Persona persona1 = personaService.findById(persona.getId()).get();
        persona1.setSexo(persona.getSexo());
        return personaService.modifyPersona(persona1);

    }
}
