package com.brunocosimano.rnp.repository;

import java.util.ArrayList;
import com.brunocosimano.rnp.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{

    @Query("SELECT a FROM Persona a WHERE a.apellido LIKE :apellido%")
    public ArrayList<Persona> findByApellido(@Param("apellido")String apellido);

    @Query("SELECT a FROM Persona a WHERE a.dni = :dni")
    public ArrayList<Persona> findByDni(@Param("dni")Integer dni);
   
}
