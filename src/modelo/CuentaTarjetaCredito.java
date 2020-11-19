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
public class CuentaTarjetaCredito extends Cuenta{
    private float cupoCredito;
    private float deuda;

    public CuentaTarjetaCredito(float cupoCredito, float deuda, int numeroCuenta,String tipo, float saldo) {
        super(numeroCuenta, saldo, tipo);
        this.cupoCredito = cupoCredito;
        this.deuda = deuda;
    }

    public CuentaTarjetaCredito() {
        this.cupoCredito = 8000000;
        this.numeroCuenta = 50;
        this.tipo = "Tarjeta de Credito";
    }

    public float getCupoCredito() {
        return cupoCredito;
    }

    public void setCupoCredito(float cupoCredito) {
        this.cupoCredito = cupoCredito;
    }

    @Override
    public void Depositar(float valor) {
        
    }

    @Override
    public float retirar(float valor) {
        float re = this.cupoCredito - valor;
        return re;
    }

    @Override
    public String consultarSaldo() {
        return "\nEl saldo es: "+this.saldo;
    }
    
    
   
    
    
    
}
