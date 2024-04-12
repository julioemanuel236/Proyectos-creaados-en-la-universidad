/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author pablobasulto
 */
public class ClaseReporteQuirurjico extends ClaseReporteInternado{
    
    public String operacion;
    public String proceso;
    public int complejidad;
    public ClaseHora horaSalida;
    //Se tomará la hora del Reporte interno como hora de entrada.

    //Constructor:

    public ClaseReporteQuirurjico(String operacion, String proceso, int complejidad, Modelo.ClaseHora horaSalida, int avanceEnfermedad, ArrayList<ClaseRecetas> listaRecetas, ClaseFecha fecha, Modelo.ClaseHora hora, String observacion) {
        super(avanceEnfermedad, listaRecetas, fecha, hora, observacion);
        this.operacion = operacion;
        this.proceso = proceso;
        this.complejidad = complejidad;
        this.horaSalida = horaSalida;
    }

    
    
    
    //Getters:
    public String getOperacion() {
        return operacion;
    }

    public String getProceso() {
        return proceso;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public Modelo.ClaseHora getHoraSalida() {
        return horaSalida;
    }
    
    

    //Setters:
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public void setHoraSalida(Modelo.ClaseHora horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    

    @Override
    public String toString() {
        return "Fecha:" + getFecha().toString() +"\nHora de entrada: " + getHora().toString() + "\nHora de salida: " + getHoraSalida().toString() 
                + "\nTipo de operación: "  + getOperacion() + "\nProceso quirúrjico: " + getProceso() + "\nComplejidad: " + getComplejidad();
    }
    
    
}
