/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaderolesypermisos.persistencia;

import com.mycompany.sistemaderolesypermisos.logica.Rol;
import com.mycompany.sistemaderolesypermisos.logica.Usuario;
import com.mycompany.sistemaderolesypermisos.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JEFFERSON ALQUINGA
 */
public class ControladoraPersistencia {
    
 
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    public List<Usuario> validarUsuario() {
        
        return usuJpa.findUsuarioEntities();
    }

    public List<Usuario> traerUsuarios() {
        
       return usuJpa.findUsuarioEntities();
       
       
    }

    public List<Rol> traerRoles() {
        
        return rolJpa.findRolEntities();
        
    }

    public void guardarUsuario(Usuario usr) {
        
        usuJpa.create(usr);
    }

    public void eliminarUsuario(int num_usuario) {
        
        try {
            usuJpa.destroy(num_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void editarUsuario(Usuario usu) {
        
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
