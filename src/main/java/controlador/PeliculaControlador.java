/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Pelicula;
import servicio.PeliculaServicio;



/**
 *
 * @author user
 */
public class PeliculaControlador {
    
        private final PeliculaServicio personajeServicio = new PeliculaServicio();
    
    public Pelicula crear(String [] args) {
        
          var pelicula = new Pelicula (args[0],args[1],Integer.valueOf(args[2]),Integer.valueOf(args[3]),args[4]);
      
        
        
        
        
        this.personajeServicio.crear(pelicula);
        return pelicula;
    }
    
    public List<Pelicula> listar() {
        return this.personajeServicio.listar();
    }
    
    
     
    
    
}
