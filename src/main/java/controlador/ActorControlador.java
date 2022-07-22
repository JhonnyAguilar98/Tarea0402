/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Actor;
import servicio.ActorServicio;

/**
 *
 * @author user
 */
public class ActorControlador {
    
    private final ActorServicio actorServicio = new ActorServicio();
    
    public Actor crear(String [] args) throws RuntimeException{
        
        var actor = new Actor(args[0],args[1],Integer.valueOf(args[2]),Integer.valueOf(args[4]), args[3]);
        this.actorServicio.crear(actor);
        return actor;
    }
    private int convertirEntero(String numero){
        try
        {
            return Integer.valueOf(numero);
        }catch(NumberFormatException e){
            throw new RuntimeException("El campo ingresaso solamente recibe "
                    + "números");
        }catch(Exception e){
            throw new RuntimeException("Error inesperado");
        }
    }
    public List<Actor> listar(){
        return this.actorServicio.listar();
    }
}
