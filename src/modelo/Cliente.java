/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Juan
 */
public class Cliente {
   private String nombre;
    private String id;
    private String telefono;
    
    //Constructor
    public Cliente (String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }
    public Cliente() {
        this.nombre = "";
        this.id = "";
        this.telefono = "";
    }
    
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nCliente: "+ this.nombre+
                "\nID: "+this.id+
                "\nTelefono: "+this.telefono+"\n";
    }
    
    
}
