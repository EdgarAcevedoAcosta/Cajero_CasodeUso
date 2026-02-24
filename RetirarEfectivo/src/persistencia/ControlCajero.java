/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import clases.*;
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
     * Para validar una Tarjeta, con las tarjetas que tiene el cajero, por su
     * numero de tarjeta y su contraseña, validar que existe la tarjeta y ve si 
     * es su conrtraseña
     * @param tar
     * @return
     */
    public boolean comprobarTargeta(Tarjeta tar){
        if(ValidarContrasenha(tar) && ValidarNumTarjeta(tar)){
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
     * Obtiene una tarjeta por el numero de tarjeta, obtiene toda la tarjeta
     * @param tar Taejeta que Nadamas Tenga Numero de Tarjeta y Contraseña
     * @return Devuelve una tarjeta completa o null si no existe
     */
    public Tarjeta obtenerTarjeta(Tarjeta tar){
        List<Tarjeta> listaTarjeta=cajero.getListaTarjeta();
        if(!listaTarjeta.isEmpty()){
            for(Tarjeta tarjeta: listaTarjeta){
                if(tarjeta.getNumTarjeta()== tar.getNumTarjeta()){
                    return tarjeta;
                }
            }
        }
        return null;
    }
    
    public void listaTarjetas(){
        List<Tarjeta> listaTarjeta=cajero.getListaTarjeta();
        if(!listaTarjeta.isEmpty()){
            for(Tarjeta tarjeta: listaTarjeta){
                System.out.println(tarjeta.getNumTarjeta());
                System.out.println(tarjeta.getContrasenha());
            }
        }
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
            cajero.AgregarTrajeta(tar);
            return true;
        }
        cajero.AgregarTrajeta(tar);
        return true;
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
        boolean retiro=false;
        retiro= ActualizarValorCajero(caj,montoFinal);
        retiro= ActualizarValorTarjeta(tar,montoFinal);
        System.out.println("Se Realizo la Actualización");
        return retiro;
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

    public Cajero getCajero() {
        return cajero;
    }
    
    
}
