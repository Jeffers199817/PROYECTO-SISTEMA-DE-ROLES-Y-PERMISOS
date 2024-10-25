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
    public static final Usuario EMAIL_CONTRASENIA_INCORRECTA = new Usuario();
    Usuario usr = new Usuario();
    Rol rol1 = new Rol();
    public ControladoraLogica(){ 
        
     controlPersis= new ControladoraPersistencia();
    
        
    }

    public Usuario validarUsuario(String nombreUsuario, String contrasenia) {
        
        
        //CREAR UN OBJETO ESPECIAL
        
        
        //String mensaje = "";
        Usuario  usr = null;
        
        List<Usuario> listaUsuario = controlPersis.validarUsuario();
        
        for(Usuario usu : listaUsuario){ 
            
            if(usu.getNombreUsuario().equals(nombreUsuario)){
                
                if(usu.getContrasenia().equals(contrasenia)){
                    
      
                    
                    return usr = usu ;
                }else{ 
                   return  usr = EMAIL_CONTRASENIA_INCORRECTA;
                }
                        
                        
                
            }else{
                usr = null;
            }
            
        }
        return usr = null;
    }
    
    
    

    public List<Usuario> traerUsuario() {
        
        return controlPersis.traerUsuarios();
    }

    public void guardarUsuario(String nombreUsuario, String contrasenia, int rol) {
        Usuario usr1 = new Usuario();
        usr1.setNombreUsuario(nombreUsuario);
        usr1.setContrasenia(contrasenia);
        
       
        List<Rol> listaRol = traerRoles();
       
        for(Rol roles: listaRol){ 
            
            System.out.println("rol: " + roles.getRol()+ roles.getId());
            
            
        if(roles.getId() == 1 && rol==1){ 
            
            
            usr1.setUnRol(roles);
           controlPersis.guardarUsuario(usr1);
           break;
  
            
        }
        if(roles.getId() == 2 && rol ==2){ 
            
            usr1.setUnRol(roles);
            
            controlPersis.guardarUsuario(usr1);
            break;
   
            
        }
   
        }
        
      
    }


    public List<Rol> traerRoles(){ 
        
        return controlPersis.traerRoles();
    }

    public void eliminarUsuario(int num_usuario) {
        
        controlPersis.eliminarUsuario(num_usuario);
        
    }

    public void editarUsuario(int numUsuario, String nombreUsuario, String contrasenia, int rol) {
        
        
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        List<Rol> listaRoles1 = controlPersis.traerRoles();
        
       for(Usuario usu : listaUsuarios){ 
           
           if(usu.getId() == numUsuario){ 
               usu.setNombreUsuario(nombreUsuario);
               usu.setContrasenia(contrasenia);
               
               for(Rol rol1 : listaRoles1){ 
                   
                   if(rol1.getId() ==1 && rol==1){
                       
                       usu.setUnRol(rol1);
                   }
                   if(rol1.getId() == 2 && rol == 2){ 
                       
                    usu.setUnRol(rol1);
                   }
                   
               }
              
               
               System.out.println("Si termine de editar");
           }
           
           controlPersis.editarUsuario(usu);
       }
        
        
    }


}
