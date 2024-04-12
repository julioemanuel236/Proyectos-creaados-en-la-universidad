/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_modelo;

public class Evento {
    private String descripcion;
    private int cantidadInvitados;
    private double largo,ancho,alto;
    private int cantidadMesas;
    private double precio;

    public Evento(String descripcion, int cantidadInvitados, double largo, double ancho, double alto, int cantidadMesas, double precio) {
        this.descripcion = descripcion;
        this.cantidadInvitados = cantidadInvitados;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.cantidadMesas = cantidadMesas;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadInvitados() {
        return cantidadInvitados;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public int getCantidadMesas() {
        return cantidadMesas;
    }

    public double getPrecio() {
        return precio;
    }
    
}
