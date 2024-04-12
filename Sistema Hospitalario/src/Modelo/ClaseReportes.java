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
public abstract class ClaseReportes {
    
    private ArrayList<ClaseRecetas> listaRecetas;
    private ClaseFecha fecha;
    private ClaseHora hora;
    private String observacion;
   
    public ClaseReportes(ArrayList<ClaseRecetas> listaRecetas, ClaseFecha fecha, ClaseHora hora, String observacion) {
        this.listaRecetas = listaRecetas;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
    }
    
    
    
    
    //Getters:
    public ArrayList<ClaseRecetas> getListaRecetas() {
        return listaRecetas;
    }

    public ClaseFecha getFecha() {
        return fecha;
    }

    public ClaseHora getHora() {
        return this.hora;
    }
    
    public String getObservacion(){
        return this.observacion;
    }
    
    //Setters:
    public void setListaRecetas(ArrayList<ClaseRecetas> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    public void setFecha(ClaseFecha fecha) {
        this.fecha = fecha;
    }
    
    public void ClaseHora(ClaseHora hora){
        this.hora = hora;
    }
    
    public void setObservacion(String observacion){
        this.observacion = observacion;
    }
    
    
    
    //toString:
    @Override
    public String toString() {
        System.out.println("Fecha: " + getFecha().toString() + "\nHora:" + getHora().toString() + "\nObservaciones: " + getObservacion());
        for(int i = 0; i < getListaRecetas().size(); i++){
            System.out.println(getListaRecetas().get(i).toString());
        }
        return null;
    }

    
    
    
    
    
    
}
