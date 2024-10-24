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

    public Usuario validarUsuario(String nombreUsuario, String contrasenia) {
        
        
        //String mensaje = "";
        Usuario  usr = null;
        
        List<Usuario> listaUsuario = controlPersis.validarUsuario();
        
        for(Usuario usu : listaUsuario){ 
            
            if(usu.getNombreUsuario().equals(nombreUsuario)){
                
                if(usu.getContrasenia().equals(contrasenia)){
                    
      
                    
                    return usr = usu ;
                }else{ 
                   return  usr = null;
                }
                        
                        
                
            }else{
                usr = null;
            }
            
        }
        return usr = null;
    }


    
    
}
