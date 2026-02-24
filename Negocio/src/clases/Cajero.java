/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;
import persistencia.CajeroObservador;

/**
 *
 * @author edgar
 */
public class Cajero {
    private int idCajero;
    public double cantidadDinero;
    private Usuario usuario;
    private Tarjeta tarjeta;
    private List<Tarjeta> listaTarjeta;
    private List<CajeroObservador> observers;
    private static Cajero instance;
    
    public void addObserver(CajeroObservador obs){
        observers.add(obs);
    }
    
    public void notifyObservers(){
        for (CajeroObservador obs: observers){
            obs.update();
        }
    }
    
    /**
     * Para cuando ya se hace un retiro de dinero actualiza el estado del dinero que hay dentro del cajero
     * @param dinero dinero retirado
     */
    public void hacerRetiro(){
        notifyObservers();
    }
    
    public static Cajero crear(){
        if(instance == null){
            instance=new Cajero(1,1500.00);
        }
        return instance;
        
    }

    private Cajero(int idCajero, double cantidadDinero) {
        this.idCajero = idCajero;
        this.cantidadDinero = cantidadDinero;
        observers= new ArrayList<>();
        listaTarjeta= new ArrayList<>();
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public double getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Tarjeta> getListaTarjeta() {
        return listaTarjeta;
    }
    
    
    
    
    
}
