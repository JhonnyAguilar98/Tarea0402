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
import modelo.Pelicula;

/**
 *
 * @author user
 */
public class PeliculaServicio implements IPeliculaServicio {
    private static List<Pelicula> peliculaList = new ArrayList<>();

    @Override
    public Pelicula crear(Pelicula pelicula) {
        
        var peliculaBuscado=this.buscarPorCodigo(pelicula.getCodigo());
        if(peliculaBuscado==null){
        this.peliculaList.add(pelicula);
        try {
        this.almacenarEnArchivo(pelicula, "C:/carpeta1/archivoPelicula.dat");
        } catch (IOException ex) {

            }
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado a la Pelicula: "+peliculaBuscado.getNombre());
        }
        return pelicula; 
 }

    @Override
    public List<Pelicula> listar() {
        List<Pelicula> retorno=null;
        try {
        retorno=this.recuperarDeArchivo("C:/carpeta1/archivoPelicula.dat");
        } catch (IOException ex) {
           return this.peliculaList;
     }
        
        return retorno;
    }

    @Override
    public Pelicula buscarPorCodigo(int codigoPelicula) {
        
                Pelicula pelicula=null;
        for(var c:this.peliculaList){
            if(codigoPelicula==c.getCodigo()){
                pelicula=c;
                break;
            }
        }
        return pelicula;
        }
    
   @Override
    public boolean almacenarEnArchivo(Pelicula pelicula, String rutaArchivo) throws IOException{
        var retorno = false;
        DataOutputStream salida=null;
        try{
            salida = new DataOutputStream( new FileOutputStream(rutaArchivo,true) );
            salida.writeUTF(pelicula.getNombre());
            salida.writeUTF(pelicula.getPeliculaTipo());
            salida.writeInt(pelicula.getAnioDeEstreno());
            salida.writeInt(pelicula.getCodigo());
            salida.writeUTF(pelicula.getPaisOrigen());
            salida.close();
            retorno=true;
        }catch(IOException e)
        {
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Pelicula> recuperarDeArchivo(String rutaArchivo) throws IOException {
        var peliculaList = new ArrayList<Pelicula>();
        DataInputStream entrada=null;
        try{
            entrada = new DataInputStream(new FileInputStream(rutaArchivo));
            while(true){
                var nombre=entrada.readUTF();
                var peliculaTipo=entrada.readUTF();
                var anioDeEstreno=entrada.readInt();
                var codigo=entrada.readInt();
                var paisOrigen=entrada.readUTF();
                var pelicula = new Pelicula(nombre,peliculaTipo,anioDeEstreno,codigo,paisOrigen);
                peliculaList.add(pelicula);
            }
        }catch(IOException e){
            entrada.close();
        }

        return peliculaList;
    } 
    
}
