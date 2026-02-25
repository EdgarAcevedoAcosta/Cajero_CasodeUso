package main;

import clases.Cajero;
import declaraciones.Declaraciones;
import frames.FrmIniciarSesionT;
import persistencia.ControlCajero;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author edgar
 */
public class RetirarEfectivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cajero cs= Cajero.crear();
        ControlCajero control= new ControlCajero(cs);
        Declaraciones ds=new Declaraciones(control);
        
        FrmIniciarSesionT frm=new FrmIniciarSesionT(control);
        frm.setVisible(true);
    }
    
}
