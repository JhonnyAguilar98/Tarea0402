/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.io.IOException;
import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author user
 */
public interface IPeliculaServicio {
    
     public Pelicula crear(Pelicula pelicula);
     public Pelicula buscarPorCodigo(int codigoPelicula);
     public List<Pelicula> listar(); 
     public boolean almacenarEnArchivo(Pelicula pelicula, String rutaArchivo) throws IOException;
     public List<Pelicula> recuperarDeArchivo(String rutaArchivo) throws IOException;
}
