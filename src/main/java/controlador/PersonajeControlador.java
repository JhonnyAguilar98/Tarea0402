/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.util.List;
import modelo.Actor;
import modelo.Pelicula;
import modelo.Personaje;
import servicio.ActorServicio;
import servicio.PeliculaServicio;
import servicio.PersonajeServicio;




/**
 *
 * @author user
 */

public class PersonajeControlador {
    
     private final PersonajeServicio personajeServicio = new PersonajeServicio();
     private final ActorServicio     actorServicio = new ActorServicio();
     private final PeliculaServicio  peliculaServicio= new PeliculaServicio();
     
    
     
     
    public Personaje crear(String [] args) {
        
        
          Pelicula pelicula =this.peliculaServicio.buscarPorCodigo(Integer.valueOf(args[4]));
          
          Actor actor =this.actorServicio.buscarPorCodigo(Integer.valueOf(args[3]));
          
           Personaje personaje = new Personaje(args[0],args[1],Integer.valueOf(args[2]),pelicula, actor);
     
    
        this.personajeServicio.crear(personaje);
        return personaje;
    }
    
     public Personaje buscarPersonaje (String arg){
     return this.personajeServicio.buscarPorCodigo(Integer.valueOf(arg));
     }
     
     
        public Personaje eliminar(String arg){
        return this.personajeServicio.eliminar(Integer.valueOf(arg));
    }
    
    public Personaje modificar(String [] args){
        Actor actor = this.actorServicio.buscarPorCodigo(Integer.valueOf(args[3]));
        Pelicula pelicula = this.peliculaServicio.buscarPorCodigo(Integer.valueOf(args[4]));
        Personaje personajeNuevo = new Personaje(args[0],args[1],Integer.valueOf(args[2]),pelicula, actor);
        this.personajeServicio.modificar(Integer.valueOf(args[0]), personajeNuevo);
        return personajeNuevo;
    }
    
    public List<Personaje> listar() {
        return this.personajeServicio.listar();
    }
    
    
    

    
}
