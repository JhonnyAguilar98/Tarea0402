/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.io.IOException;
import java.util.List;
import modelo.Actor;

/**
 *
 * @author user
 */
public interface IActorServicio {
    
    public Actor crear(Actor actor);
    public Actor buscarPorCodigo(int codigoActor);
    public List<Actor> listar(); 
    public boolean almacenarEnArchivo(Actor actor, String rutaArchivo) throws IOException;
    public List<Actor> recuperarDeArchivo(String rutaArchivo) throws IOException;
    
}
