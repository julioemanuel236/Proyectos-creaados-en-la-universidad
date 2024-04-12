/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_modelo;

public class Cliente {

    private String rut;
    private String nombreCompleto;
    private String correo;
    private String numero;

    public Cliente(String rut, String nombreCompleto, String correo, String numero) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numero = numero;
    }

    public String getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }
    
    
}
