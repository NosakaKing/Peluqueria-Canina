/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;
    private String nombre;
    private String raza;
    private String color;
    private String Alergico;
    private String Atencion_especial;
    private String Observaciones;
    
    @OneToOne
    private Duenio due;

    public Mascota() {
    }

    public Mascota(int num_cliente, String nombre, String raza, String color, String Alergico, String Atencion_especial, String Observaciones, Duenio due) {
        this.num_cliente = num_cliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.Alergico = Alergico;
        this.Atencion_especial = Atencion_especial;
        this.Observaciones = Observaciones;
        this.due = due;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return Alergico;
    }

    public void setAlergico(String Alergico) {
        this.Alergico = Alergico;
    }

    public String getAtencion_especial() {
        return Atencion_especial;
    }

    public void setAtencion_especial(String Atencion_especial) {
        this.Atencion_especial = Atencion_especial;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Duenio getDue() {
        return due;
    }

    public void setDue(Duenio due) {
        this.due = due;
    }
    
    
}
