/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author nosaka
 */
public class ControladoraPersistencia {
    
    DuenioJpaController DuenioJPA = new DuenioJpaController();
    MascotaJpaController MascotaJPA= new MascotaJpaController();

    public void guardar(Duenio duen, Mascota mas) {
        
        DuenioJPA.create(duen);
        MascotaJPA.create(mas);
    }

    public List<Mascota> traerMascotas() {
        return MascotaJPA.findMascotaEntities();
    }

    public void eliminarMascota(int num_cliente) {
        try {
            MascotaJPA.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
       return MascotaJPA.findMascota(num_cliente);
    }

    public Duenio traerDuenio(int id_Duenio) {
       return DuenioJPA.findDuenio(id_Duenio);
    }

    public void modificarMascota(Mascota masco) {
        try {
            MascotaJPA.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarDuenio(Duenio due) {
        try {
            DuenioJPA.edit(due);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
