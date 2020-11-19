/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.Movimiento;
import vista.Observer2;
import vista.Ventana;
/**
 *
 * @author Juan
 */
public class Controlador implements ActionListener{
 
    Cliente objCl;
    ListaCuentas list;
    Banco objB;
    Ventana frmV;
    Observer2 obs;
    Movimiento frmM;

    public Controlador(Observer2 obs,Cliente objCl, ListaCuentas list,Banco objB, Ventana frmV,Movimiento frmM) {
        
        this.objCl = objCl;
        this.list = list;
        this.objB = objB;
        this.frmV = frmV;
        this.frmM = frmM;
        this.obs = obs;
    }
    public Controlador() {
        
        this.list = new ListaCuentas();
        this.objB = new Banco();
        this.frmV = new Ventana();
        this.frmM = new Movimiento();
        this.obs = new Observer2();
        this.list.addObserver(frmM);
        this.list.addObserver(obs);
        frmV.getBtnAgregar().addActionListener(this);
        frmV.getRbtCuentaAhorros().addActionListener(this);
        frmV.getRbtTargetaCredito().addActionListener(this);
        frmV.getBtnConsignar().addActionListener(this);
        frmV.getBtnRetirar().addActionListener(this);
        frmV.getBtnConsultar().addActionListener(this);
        
    }
    
    public void iniciar(){
        frmV.setVisible(true);
        frmV.setLocationRelativeTo(null);
        frmM.setVisible(true);
        frmM.setLocationRelativeTo(frmV);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if(ae.getSource() == frmV.getBtnAgregar()){
            
            objCl = new Cliente();
            objCl.setNombre(frmV.getTxtNombre().getText());
            objCl.setId(frmV.getTxtID().getText());
            objCl.setTelefono(frmV.getTxtTelefono().getText());
            
            
            if(frmV.getRbtCuentaAhorros().isSelected()){
                
                CuentaAhorros objCH= new CuentaAhorros();
                objCH.setNumeroCuenta((int) (Math.random()*100));
                list.adicionaCuenta(objCH);
                objB.agregarCuenta(list);
                JOptionPane.showMessageDialog(frmV, "Cuenta registrada con exito!");
                JOptionPane.showMessageDialog(frmV,"Su clave es: "+objCH.getClave()+"\nSu Numero de cuenta es: "+objCH.getNumeroCuenta());
           
            }
            
            if(frmV.getRbtTargetaCredito().isSelected()){
                 
                 CuentaTarjetaCredito objT = new CuentaTarjetaCredito();
                 objT.setNumeroCuenta((int) (Math.random()*100));
                 list.AdicionarCuenta2(objT);
                 objB.agregarCuenta(list);
                 JOptionPane.showMessageDialog(frmV, "Cuenta registrada con exito!");
                 JOptionPane.showMessageDialog(frmV,"Su Numero de cuenta es: "+objT.getNumeroCuenta());
                 
            }
            
        }
        
        //Boton consignar
        if(ae.getSource() == frmV.getBtnConsignar()){
            
            //rbtCuentaAhorros
            if(frmV.getRbtCuentaAhorros().isSelected()){
               
                int resp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la cuenta a la cual desea consignar: "));
               
                for(int i=0;i<list.getListaAhorros().size(); i++){
            
                   if(list.getListaAhorros().get(i).getNumeroCuenta() == resp){
                       
                       String clave = JOptionPane.showInputDialog("Ingrese su clave");
                       
                        if(list.getListaAhorros().get(i).getClave().equals(clave)){
                       
                            int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a consignar"));
                            list.getListaAhorros().get(i).Depositar(valor);
                            list.actAhorro(list.getListaAhorros().get(i).getNumeroCuenta(), valor);
                   
                        }else{
                            JOptionPane.showMessageDialog(frmV,"Clave incorrecta");
                        }
                        
                   }else{
                       JOptionPane.showMessageDialog(frmV,"Numero de cuenta no encontrado");
                   }  
               }
            }
            
            //rbtCuentaTarjetadeCredito
            if(frmV.getRbtTargetaCredito().isSelected()){
                
                int resp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la cuenta a la cual desea consignar: "));
                
                for(int i=0; i<list.getListaTarjeta().size(); i++){
                    
                    if(list.getListaTarjeta().get(i).getNumeroCuenta()==resp){
                        
                        int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a consignar"));
                        list.getListaTarjeta().get(i).Depositar(valor);
                        list.actAhorro(list.getListaTarjeta().get(i).getNumeroCuenta(), valor);
                    }else{
                       JOptionPane.showMessageDialog(frmV,"Numero de cuenta no encontrado");
                   }
                }
            }  
        }
        
        //boton retirar
        if(ae.getSource()== frmV.getBtnRetirar()){
            
            if(frmV.getRbtCuentaAhorros().isSelected()){
                
                int resp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la cuenta de la cual desea retirar: "));
                
                for(int i=0; i<list.getListaAhorros().size(); i++){
                    
                    if(list.getListaAhorros().get(i).getNumeroCuenta()==resp){
                        
                        String clave = JOptionPane.showInputDialog("Ingrese su clave");
                       
                        if(list.getListaAhorros().get(i).getClave().equals(clave)){
                       
                            int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a retirar"));
                            list.getListaAhorros().get(i).retirar(valor);
                            list.getListaAhorros().get(i).setSaldo(list.getListaAhorros().get(i).getSaldo()-valor);
                            list.retiAhorro(list.getListaAhorros().get(i).getNumeroCuenta(), valor);
                            
                        }else{
                            JOptionPane.showMessageDialog(frmV,"Clave incorrecta");
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(frmV,"Numero de cuenta no encontrado");
                    }
                }
            }
            if(frmV.getRbtTargetaCredito().isSelected()){
                int resp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la cuenta a la cual desea consignar: "));
                
                for(int i=0; i<list.getListaTarjeta().size(); i++){
                    
                    if(list.getListaTarjeta().get(i).getNumeroCuenta()== resp){
                        
                        int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a retirar"));
                        list.getListaTarjeta().get(i).retirar(valor);
                        list.getListaTarjeta().get(i).setCupoCredito(list.getListaTarjeta().get(i).getCupoCredito()-valor);
                        list.retiTarjeta(list.getListaTarjeta().get(i).getNumeroCuenta(), valor);
                    }else{
                       JOptionPane.showMessageDialog(frmV,"Numero de cuenta no encontrado");
                   }
                }
            }
        }
        
        //Boton consultar
        if(frmV.getBtnConsultar() == ae.getSource()){
            
            //rbtCuentaAhorros
            if(frmV.getRbtCuentaAhorros().isSelected()){
               
                int resp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la cuenta a la cual desea consultar: "));
                
                for(int i=0; i<list.getListaAhorros().size(); i++){
                    
                    if(list.getListaAhorros().get(i).getNumeroCuenta()== resp){
                        
                        String clave = JOptionPane.showInputDialog("Ingrese su clave");
                       
                        if(list.getListaAhorros().get(i).getClave().equals(clave)){
                       
                            frmV.getTxtaResp().append(list.getListaAhorros().get(i).consultarSaldo());
                            frmV.getTxtaResp().append(objCl.toString());
                            list.consulAhorro(list.getListaAhorros().get(i).getNumeroCuenta());
                        }else{
                            JOptionPane.showMessageDialog(frmV,"Clave incorrecta");
                        }
                        
                    }else{
                      JOptionPane.showMessageDialog(frmV,"Numero de cuenta no encontrado");
                    }
                }
            }
            //rbtCuentaTarjetaCredito
            if(frmV.getRbtTargetaCredito().isSelected()){
                
                int resp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la cuenta que desea consultar "));
                
                for (int i = 0; i <list.getListaTarjeta().size(); i++) {
                    
                    if(list.getListaTarjeta().get(i).getNumeroCuenta()==resp){
                        
                        frmV.getTxtaResp().append(String.valueOf(list.getListaTarjeta().get(i).getCupoCredito()));
                        frmV.getTxtaResp().append(objCl.toString());
                        list.consulAhorro(list.getListaTarjeta().get(i).getNumeroCuenta());
                    }else{
                        JOptionPane.showMessageDialog(frmV,"Numero de cuenta no encontrado");
                    }
                }
            }
        }
    }
    
}
