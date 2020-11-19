/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Hades
 */
public class Observer2 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
