/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_modelo;

public class Fiesta extends Evento{
    
    private int cantidadDJ;
    private boolean alcohol;

    public Fiesta(int cantidadDJ, boolean alcohol, String descripcion, int cantidadInvitados, double largo, double ancho, double alto, int cantidadMesas, double precio) {
        super(descripcion, cantidadInvitados, largo, ancho, alto, cantidadMesas, precio);
        this.cantidadDJ = cantidadDJ;
        this.alcohol = alcohol;
    }

    

    public int getCantidadDJ() {
        return cantidadDJ;
    }

    public boolean isAlcohol() {
        return alcohol;
    }
}
