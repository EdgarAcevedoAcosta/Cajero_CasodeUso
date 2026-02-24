/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package declaraciones;

import clases.*;
import persistencia.ControlCajero;

/**
 *
 * @author edgar
 */
public class Declaraciones {
    private ControlCajero control;

    public Declaraciones(ControlCajero cs) {
        this.control=cs;
        agregarTarjetas();
    }
    
    public void agregarTarjetas(){
        Usuario user= new Usuario("Edgar Aceved0");
        Usuario user2= new Usuario("Carlos Gonzales");
        Usuario user3= new Usuario("Jose Jose");
        
        Tarjeta tar1=new Tarjeta("4546 3213 3214 3214", 1234, 2500.00, user);
        Tarjeta tar2=new Tarjeta("4546 6346 4342 6543", 2341, 900.00, user2);
        Tarjeta tar3=new Tarjeta("4546 2535 5763 2454", 7456, 500.00, user3);
        control.agregarTarjeta(tar1);
        control.agregarTarjeta(tar2);
        control.agregarTarjeta(tar3);
    }
    
}
