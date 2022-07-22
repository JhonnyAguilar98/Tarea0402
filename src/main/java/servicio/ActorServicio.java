/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Actor;


/**
 *
 * @author user
 */
public class ActorServicio implements IActorServicio {
    
    private static List<Actor> actorList = new ArrayList<>();

    @Override
    public Actor crear(Actor actor) {
        var actorBuscado=this.buscarPorCodigo(actor.getCodigo());
        if(actorBuscado==null){
        this.actorList.add(actor);
        try {
        this.almacenarEnArchivo(actor, "C:/carpeta1/archivoActor.dat");
        } catch (IOException ex) {

            }
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al Actor: "+actorBuscado.getNombre());
        }
        return actor;    
    }
    
    

    @Override
    public List<Actor> listar() {
         List<Actor> retorno=null;
        try {
            retorno=this.recuperarDeArchivo("C:/carpeta1/archivoActor.dat");
        } catch (IOException ex) {
           
         return this.actorList;
     }
        return retorno;
    }

    @Override
    public Actor buscarPorCodigo(int codigoActor) {
        Actor actor=null;
        for(var c:this.actorList){
            if(codigoActor==c.getCodigo()){
                actor=c;
                break;
            }
        }
        return actor;
     }

    @Override
    public boolean almacenarEnArchivo(Actor actor, String rutaArchivo) throws IOException{
        var retorno = false;
        DataOutputStream salida=null;
        try{
            salida = new DataOutputStream( new FileOutputStream(rutaArchivo,true) );
            salida.writeUTF(actor.getNombre());
            salida.writeUTF(actor.getNacionalidad());
            salida.writeInt(actor.getEdad());
            salida.writeUTF(actor.getPais());
            salida.writeInt(actor.getCodigo());
            salida.close();
            retorno=true;
        }catch(IOException e)
        {
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Actor> recuperarDeArchivo(String rutaArchivo) throws IOException {
        var actorList = new ArrayList<Actor>();
        DataInputStream entrada=null;
        try{
            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
            while(true){
                var nombre=entrada.readUTF();
                var nacionalidad=entrada.readUTF();
                var edad=entrada.readInt();
                 var pais=entrada.readUTF();
                var codigo=entrada.readInt();
                var actor = new Actor(nombre,nacionalidad,edad,pais,codigo);
                actorList.add(actor);
            }
        }catch(IOException e){
            entrada.close();
        }

        return actorList;
    }

}
