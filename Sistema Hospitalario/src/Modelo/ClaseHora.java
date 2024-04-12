/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pablobasulto
 */
public class ClaseHora {
    
    private int hora;
    private int minutos;
    
    //Constructor:

    public ClaseHora(int hora, int minutos) {
        setHora(hora);
        setMinutos(minutos);
    }
    
    //Getters:

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }
    
    //Setters:

    public void setHora(int hora) {
        if (hora <= 0|| hora > 24){
            this.hora = 0;
        }
        else this.hora = hora;
    }

    public void setMinutos(int minutos) {
        if (minutos <= 0 || minutos > 60 ){
            this.minutos = 0;
        }
        else this.minutos = minutos;
        
    }
    
    //to String:

    @Override
    public String toString() {
        return getHora() + ":" + getMinutos();
    }
    
    
    
}
