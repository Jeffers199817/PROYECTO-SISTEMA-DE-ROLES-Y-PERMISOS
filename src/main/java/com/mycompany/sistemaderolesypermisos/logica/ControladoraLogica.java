/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaderolesypermisos.logica;

import com.mycompany.sistemaderolesypermisos.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author JEFFERSON ALQUINGA
 */
public class ControladoraLogica {
    ControladoraPersistencia controlPersis = null;
    
    public ControladoraLogica(){ 
        
     controlPersis= new ControladoraPersistencia();
    
        
    }

    public String validarUsuario(String nombreUsuario, String contrasenia) {
        
        
        String mensaje = "";
        
        List<Usuario> listaUsuario = controlPersis.validarUsuario();
        
        for(Usuario usu : listaUsuario){ 
            
            if(usu.getNombreUsuario().equals(nombreUsuario)){
                
                if(usu.getContrasenia().equals(contrasenia)){
                    
                    mensaje = "Inicio de sesión exitoso" +  "Bienvenido " + usu.getNombreUsuario();
                    return mensaje;
                }else{ 
                   return mensaje = "Usuario o Contraseña incorrectos.";
                }
                        
                        
                
            }else{
                mensaje = "Usuario no existe";
            }
            
        }
        return mensaje;
    }
    
    
}
