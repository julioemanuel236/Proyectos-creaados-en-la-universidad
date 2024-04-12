/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_modelo;

import java.util.Date;

public class Registro {
    private Evento evento;
    private Cliente cliente;

    private Date fecha;
    private int hora,minutos;

    public Registro(Evento evento, Cliente cliente, Date fecha, int hora, int minutos) {
        this.evento = evento;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.minutos = minutos;
    }

    public Evento getEvento() {
        return evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    
}
