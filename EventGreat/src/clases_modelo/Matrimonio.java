/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_modelo;

public class Matrimonio extends Evento{

    private int cantidadPlatos;
    private boolean musicaEnVivo;

    public Matrimonio(int cantidadPlatos, boolean musicaEnVivo, String descripcion, int cantidadInvitados, double largo, double ancho, double alto, int cantidadMesas, double precio) {
        super(descripcion, cantidadInvitados, largo, ancho, alto, cantidadMesas, precio);
        this.cantidadPlatos = cantidadPlatos;
        this.musicaEnVivo = musicaEnVivo;
    }

    public int getCantidadPlatos() {
        return cantidadPlatos;
    }


    public boolean isMusicaEnVivo() {
        return musicaEnVivo;
    }

    
    
}
