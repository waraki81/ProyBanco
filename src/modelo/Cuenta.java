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
public abstract class Cuenta{
    protected  int numeroCuenta;
    protected  float saldo;
    protected  String tipo;
    //Constructor
    public Cuenta(int numeroCuenta, float saldo, String tipo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipo = tipo;
    }
    public Cuenta() {
        this.numeroCuenta = 0;
        this.saldo = 0;
        this.tipo = "";
    }
    
    //Getters and Setters
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public abstract void Depositar(float valor);
    
    public abstract float retirar(float valor);
    
    public  abstract String consultarSaldo();
    
}
