/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.igu;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author nosaka
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

   public void guardar(String nombreMascota, String Raza, String Color, String NombreDuenio, String Telefono, String Observaciones, String Alergico, String Atencion) {
        
       // Creamos el duenio le asignamos sus valores
       Duenio duen = new Duenio();
       duen.setNombre(NombreDuenio);
       duen.setCelDuenio(Telefono);
       
       // Creamos la mascota y asignamos sus valores
       Mascota mas = new Mascota();
       mas.setNombre(nombreMascota);
       mas.setColor(Color);
       mas.setRaza(Raza);
       mas.setAlergico(Alergico);
       mas.setObservaciones(Observaciones);
       mas.setAtencion_especial(Atencion);
       mas.setDue(duen);
       
       controlPersis.guardar(duen,mas);
       
    }

    public List<Mascota> traerMascotas() {
       return controlPersis.traerMascotas();
    }

    public void eliminarMascota(int num_cliente) {
        controlPersis.eliminarMascota (num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String Raza, String Color, String Observaciones, String Alergico, String Atencion, String NombreDuenio, String Telefono) {
        masco.setNombre(nombreMascota);
        masco.setRaza(Raza);
        masco.setColor(Color);
        masco.setObservaciones(Observaciones);
        masco.setAlergico(Alergico);
        masco.setAtencion_especial(Atencion);
        
        //Modifico la mascota
        controlPersis.modificarMascota(masco);
        
        // Steo nuevos valores a duenio
        Duenio due = this.buscarDuenio(masco.getDue().getId_Duenio());
        due.setCelDuenio(Telefono);
        due.setNombre(NombreDuenio);
        
        //Llamar al modificar al duenio
        this.modificarDuenio(due);
    }

    private Duenio buscarDuenio(int id_Duenio) {
        return controlPersis.traerDuenio(id_Duenio);
    }

    private void modificarDuenio(Duenio due) {
        controlPersis.modificarDuenio(due);
    }
}
