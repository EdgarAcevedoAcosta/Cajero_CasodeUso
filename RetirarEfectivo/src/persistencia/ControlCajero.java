/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import clases.*;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author edgar
 */
public class ControlCajero {
    private Cajero cajero;
    private static ControlCajero control;

    /**
     * Constructor del control 
     * @param cajero De un cajero
     */
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
     * @return un control de un solo control
     */
    
    public static ControlCajero crear(){
        if(control==null){
            control=new ControlCajero(Cajero.crear());
        }
        return control;
    }
    
    //------- Cajero -------------
    /**
     * Verificar el Dinero que hay en el sistema
     * @param caj el cajero a que esta haciedo una operacion
     * @param cantidad cantidad de dinero que se va hacer una transferencia
     * @return devuelve true si si se puede hacer el retiro
     */
    public boolean VerificarDineroSistema(Cajero caj, double cantidad){
        if(verCantidadDineroEnSistema(caj) >= cantidad){
            return true;
        }
        return false;
    }
    
    /**
     * Verificar la contidad del dinero del cajero
     * @param caj el cajero que esta haciendo referencia
     * @return devuelve la cantidad de dinero en el sistema/ cajero
     */
    public double verCantidadDineroEnSistema(Cajero caj){
        return caj.getCantidadDinero();
    }
    
    // ------------ Tarjetas  -----------

    /**
     * Para validar una Tarjeta, con las tarjetas que tiene el cajero, por su
     * numero de tarjeta y su contraseña, validar que existe la tarjeta y ve si 
     * es su conrtraseña
     * @param tar La Tarjeta que se va ha comprobar
     * @return Devuelve True si es que existe la tarjeta y false si no
     */
    public boolean comprobarTargeta(Tarjeta tar){
        if(ValidarContrasenha(tar) && ValidarNumTarjeta(tar)){
            return true;
        }
        return false;
    }
    
    /**
     * Comprueba por una lista de Tarjetas, comparando por el numero de tarjeta
     * @param tar Taejeta Buscada
     * @return Devuelve true si es que Existe la Tarjeta y false si no
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
    
    /**
     * Es para Imprimir la Lista de las Tarjetas que hay.
     */
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
     * Es para Agregar una Tarjeta, validando hay tarjetas, si no hay se agrega 
     * la tarjeta, si hay tarjetas valida si existe esa tarjeta por su numero de 
     * Tarjeta, si existe no la agrega, si no existe la agrega a la lista
     * @param tar Tarjeta que se va a Agregar
     * @return Devuelve true si si se Agrego y false si ya existe
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
     * Validar si el monto del Usuario para ver si puede hacer el retiro
     * @param tar Tarjeta dek Usuario
     * @param monto Cantidad a Hacer el retiro
     * @return Devuelve true si si se pude hacer el retiro, y False si no se puede hacer
     */
    public boolean ComprobarMontoUsuario(Tarjeta tar, double monto){
        if(ValidarMontoRetiro(tar) >= monto){
            return true;
        }
        return false;
    }
    
    /**
     * Mira el monto del usuario 
     * @param tar Tarjeta del Usuario
     * @return Monto del Usuario
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
     * Actualiza el Valor en el Cajero Cuando ya y Hace el Retiro
     * @param caj Cajero a que Hace Referencia
     * @param monto Cantidad del Retiro
     * @return Devuelve si se realizo el retiro
     */
    public boolean ActualizarValorCajero(Cajero caj, double monto){
        double dinero=caj.getCantidadDinero();
        caj.setCantidadDinero(dinero-monto);
        return true;
    }
    
    /**
     * Agrega la Comision que se Cobro al Usuario
     * @param caj Cajero a que Hace Referencia
     * @param monto Cantidad del Retiro
     * @return Devuelve si se realizo la acción
     */
    public boolean AgregarComision(Cajero caj, double monto){
        double dinero=caj.getCantidadDinero();
        caj.setCantidadDinero(dinero+monto);
        return true;
    }
    
    /**
     * Actualiza el Valor en la Tarjeta Cuando ya y Hace el Retiro
     * @param tar Trajeta a que Hace Referencia
     * @param monto Cantidad del Retiro
     * @return Devuelve si se realizo el retiro
     */
    public boolean ActualizarValorTarjeta(Tarjeta tar, double monto){
        double dinero=tar.getMonto();
        tar.setMonto(dinero-monto);
        return true;
        
    }

    /**
     * Metodo para Hacer Referencia de un Cajero
     * @return
     */
    public Cajero getCajero() {
        return cajero;
    }
    
    
}
