/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Banco {
    private  ArrayList <ListaCuentas> listaF= new ArrayList();
  
    public ArrayList<ListaCuentas> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<ListaCuentas> listaF) {
        this.listaF = listaF;
    }

    public void agregarCuenta(ListaCuentas objeto) {
        this.listaF.add(objeto);
    }
    public Banco() {
        this.listaF = new <Cuenta> ArrayList();
    }
    
    
}
