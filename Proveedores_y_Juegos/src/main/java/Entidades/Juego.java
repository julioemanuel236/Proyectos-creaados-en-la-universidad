package Entidades;

import java.util.UUID;

public class Juego {

    private String dni;
    private String nombre;
    private String categoria;
    private String categoriaPorAccesorios;
    private String mecanica;
    private int participante;
    private int edadMinima;
    
    public Juego(){
        this.dni = UUID.randomUUID().toString();
    }

    public Juego(String nombre, String categoria, String categoriaPorAccesorios, String mecanica, int participante, int edadMinima) {
        
        this.dni = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.categoria = categoria;
        this.categoriaPorAccesorios = categoriaPorAccesorios;
        this.mecanica = mecanica;
        this.participante = participante;
        this.edadMinima = edadMinima;
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaPorAccesorios() {
        return categoriaPorAccesorios;
    }

    public void setCategoriaPorAccesorios(String categoriaPorAccesorios) {
        this.categoriaPorAccesorios = categoriaPorAccesorios;
    }

    public String getMecanica() {
        return mecanica;
    }

    public void setMecanica(String mecanica) {
        this.mecanica = mecanica;
    }

    public int getParticipante() {
        return participante;
    }

    public void setParticipante(int participante) {
        this.participante = participante;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
    
    
    
}
