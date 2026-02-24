/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import clases.*;
import frames.FrmIniciarSeion;
import java.util.List;

/**
 *
 * @author edgar
 */
public class ControlCajero {
    private Cajero cajero;
    private static ControlCajero control;

    public ControlCajero(Cajero cajero) {
        this.cajero = cajero;
    }
    //-------- Iniciar Sesion
//    public void InciarSs(Tarjeta tar, String contrasenha){
//        FrmIniciarSeion frm=new FrmIniciarSeion();
//        frm.setVisible(true);
//    }

    /**
     * unica Instancia del control para usarlo mejor
     * @return
     */
    
    public static ControlCajero crear(){
        if(control==null){
            control=new ControlCajero(Cajero.crear());
        }
        return control;
    }
    
    //------- Cajero -------------
    /**
     *
     * @param caj
     * @param cantidad
     * @return
     */
    public boolean VerificarDineroSistema(Cajero caj, double cantidad){
        if(verCantidadDineroEnSistema(caj) >= cantidad){
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param caj
     * @return
     */
    public double verCantidadDineroEnSistema(Cajero caj){
        return caj.getCantidadDinero();
    }
    
    // ------------ Tarjetas  -----------

    /**
     *
     * @param tar
     * @return
     */
    public boolean comprobarTargeta(Tarjeta tar){
        if(ValidarContrasenha(tar)){
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param tar
     * @return
     */
    public boolean ValidarNumTarjeta(Tarjeta tar){
        List<Tarjeta> listaTarjeta=cajero.getListaTarjeta();
        if(!listaTarjeta.isEmpty()){
            for(Tarjeta tarjeta: listaTarjeta){
                if(tarjeta.getNumTarjeta()== tar.getNumTarjeta()){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Para el validar numero de Tarjeta seria casi igual. Es para Verificar el inicio de sesion,
     * para validar la tarjeta.
     * @param tar tarjeta a verificar
     * @return devuelve verdadero si existe y si es su contraseña
     */
    public boolean ValidarContrasenha(Tarjeta tar){
        List<Tarjeta> listaTarjeta=cajero.getListaTarjeta();
        if(!listaTarjeta.isEmpty()){
            for(Tarjeta tarjeta: listaTarjeta){
                if(tarjeta.getNumTarjeta()== tar.getNumTarjeta()){
                    if(tarjeta.getContrasenha()== tar.getContrasenha()){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     *
     * @param tar
     * @return
     */
    public boolean agregarTarjeta(Tarjeta tar){
        List<Tarjeta> listaTarjeta=cajero.getListaTarjeta();
        if(!listaTarjeta.isEmpty()){
            for(Tarjeta tarjeta: listaTarjeta){
                if(tarjeta.getNumTarjeta()== tar.getNumTarjeta()){
                    System.out.println("No se agrego la Tarjeta porque ya existe");
                    return false;
                }
            }
            listaTarjeta.add(tar);
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param tar
     * @param monto
     * @return
     */
    public boolean ComprobarMontoUsuario(Tarjeta tar, double monto){
        if(ValidarMontoRetiro(tar) >= monto){
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param tar
     * @return
     */
    public double ValidarMontoRetiro(Tarjeta tar){
        return tar.getMonto();
    }
    
    // ----- Hacer Retiro ----
    public boolean HacerRetiro(Cajero caj, Tarjeta tar, double montoFinal){
        ActualizarValorCajero(caj,montoFinal);
        ActualizarValorTarjeta(tar,montoFinal);
        return true;
    }
    
    /**
     *
     * @param caj
     * @param monto
     * @return
     */
    public boolean ActualizarValorCajero(Cajero caj, double monto){
        double dinero=caj.getCantidadDinero();
        caj.setCantidadDinero(dinero-monto);
        return true;
    }
    
    /**
     *
     * @param tar
     * @param monto
     * @return
     */
    public boolean ActualizarValorTarjeta(Tarjeta tar, double monto){
        double dinero=tar.getMonto();
        tar.setMonto(dinero-monto);
        return true;
        
    }
    
    
}
