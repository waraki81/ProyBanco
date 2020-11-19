/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Juan
 */
public class ListaCuentas extends Observable {
    private  ArrayList <CuentaAhorros> listaAhorros = new ArrayList(); 
    private ArrayList <CuentaTarjetaCredito> listaTarjeta = new ArrayList();

    public ArrayList<CuentaAhorros> getListaAhorros() {
        return listaAhorros;
    }

    public void setListaAhorros(ArrayList<CuentaAhorros> listaAhorros) {
        this.listaAhorros = listaAhorros;
    }

    public ArrayList<CuentaTarjetaCredito> getListaTarjeta() {
        return listaTarjeta;
    }

    public void setListaTarjeta(ArrayList<CuentaTarjetaCredito> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }
    
    
    public void adicionaCuenta(CuentaAhorros objeto) {
        this.listaAhorros.add(objeto);
    }
    public  void AdicionarCuenta2 (CuentaTarjetaCredito objeto){
        this.listaTarjeta.add(objeto);
    }
    public ListaCuentas() {
    }
    
    public void actAhorro(int numCuenta, float valor){
        String msg = "\nNumero de cuenta: "+String.valueOf(numCuenta)+"|\t|Ingreso: "+valor;
        setChanged();
        notifyObservers(msg);
    }
    public void actTarjeta(int numCuenta, float valor){
        String  msg ="\nNumero de cuenta: "+String.valueOf(numCuenta)+"|\t|Ingreso: "+valor;
        setChanged();
        notifyObservers(msg);
    }
    
    public void retiAhorro(int numCuenta, float valor){
        String msg = "\nNumero de cuenta: "+ String.valueOf(numCuenta)+"|\t|Retiro: "+valor;
        setChanged();
        notifyObservers(msg);
    }
    public void retiTarjeta(int numCuenta, float valor){
        String msg ="\nNumero de cuenta: "+String.valueOf(numCuenta)+"|\t|Retiro: "+valor;
        setChanged();
        notifyObservers(msg);
    }
    
    public void consulAhorro(int numCuenta){
        String msg ="\nNumeor de cuenta: "+String.valueOf(numCuenta)+"|\t|Consulto sus datos";
        setChanged();
        notifyObservers(msg);
    }
    public void consulTarjeta(int numCuenta){
        String msg ="\nNumero de cuenta: "+String.valueOf(numCuenta)+"|\t|Consultar sus datos";
        setChanged();
        notifyObservers(msg);
    }
}
