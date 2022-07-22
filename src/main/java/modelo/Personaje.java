/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author user
 */
public class Personaje {
    
    private String nombre;
    private String numeroDeEscenas;
    private int codigo;
    private Actor actor;
    private Pelicula pelicula;

    public Personaje(String nombre, String numeroDeEscenas, int codigo, Actor actor, Pelicula pelicula) {
        this.nombre = nombre;
        this.numeroDeEscenas = numeroDeEscenas;
        this.codigo = codigo;
        this.actor = actor;
        this.pelicula = pelicula;
    }


    public Personaje(String nombre, String numeroDeEscenas, Integer codigo, Pelicula pelicula, Actor actor) {
        this.nombre = nombre;
        this.numeroDeEscenas = numeroDeEscenas;
        this.codigo = codigo;
        this.actor = actor;
        this.pelicula = pelicula;
        
     }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDeEscenas() {
        return numeroDeEscenas;
    }

    public void setNumeroDeEscenas(String numeroDeEscenas) {
        this.numeroDeEscenas = numeroDeEscenas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", numeroDeEscenas=" +
                numeroDeEscenas + ", codigo=" + codigo + ", actor=" + actor +
                ", pelicula=" + pelicula + '}';
    }
  
}
