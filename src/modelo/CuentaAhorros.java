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
public class CuentaAhorros extends Cuenta {
    private String clave;

    public CuentaAhorros(String clave, int numeroCuenta,String tipo, float saldo) {
        super(numeroCuenta, saldo, tipo);
        this.clave = clave;
    }

    public CuentaAhorros() {
        this.clave = "123456";
        this.numeroCuenta =0;
        this.tipo = "Cuenta de Ahorros";
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public void Depositar(float valor) {
         this.saldo+=valor;
    }

    @Override
    public float retirar(float valor) {
         float re = this.saldo-valor;
         return re;
    }

    @Override
    public String consultarSaldo() {
        return "\nEl saldo es: "+this.saldo;
    }

    
  
    
    
   
}
