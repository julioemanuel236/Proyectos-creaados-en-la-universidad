/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pablobasulto
 */
public class ClaseActividades {
    
    private ClaseHora hora;
    private String tarea;
    
    //Constructor

    public ClaseActividades(ClaseHora hora, String tarea) {
        this.hora = hora;
        this.tarea = tarea;
    }
    
    //Getters:

    public ClaseHora getHora() {
        return hora;
    }

    public String getTarea() {
        return tarea;
    }
    
    //Setters:

    public void setHora(ClaseHora hora) {
        this.hora = hora;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    

    @Override
    public String toString() {
        return "\nHora" + getHora().toString() + "\nTarea:" + getTarea();
    }
    
    
    
    
    
}
