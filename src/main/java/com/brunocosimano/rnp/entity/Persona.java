package com.brunocosimano.rnp.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brunocosimano.rnp.commons.EnumGenero;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fNacimiento;
    
    private EnumGenero sexo;
    private Integer DNI;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getfNacimiento() {
        return fNacimiento;
    }
    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
    public EnumGenero getSexo() {
        return sexo;
    }
    public void setSexo(EnumGenero sexo) {
        this.sexo = sexo;
    }
    public Integer getDNI() {
        return DNI;
    }
    public void setDNI(Integer dNI) {
        DNI = dNI;
    }

}
