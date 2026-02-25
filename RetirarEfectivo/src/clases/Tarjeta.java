/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author edgar
 */
public class Tarjeta {
    private String numTarjeta;
    private int contrasenha;
    private double monto;
    private Usuario usuario;

    public Tarjeta(String numTarjeta, int contrasenha, double monto, Usuario usuario) {
        this.numTarjeta = numTarjeta;
        this.contrasenha = contrasenha;
        this.monto = monto;
        this.usuario = usuario;
    }

    public Tarjeta() {
    }
    

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(int contrasenha) {
        this.contrasenha = contrasenha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
