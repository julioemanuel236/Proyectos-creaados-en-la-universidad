/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pablobasulto
 */
public class ClaseRecetas {
    
    //Atributos:
    private String medicamento;
    private String dosis;
    private int frecuencia;
    private String via;
    
    //Constructor:
    public ClaseRecetas(String medicamento, String dosis, int frecuencia, String via) {
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.via = via;
    }
    
    //Getters:
    public String getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public String getVia() {
        return via;
    }
    
    
    //Setters:
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setVia(String via) {
        this.via = via;
    }

    @Override
    public String toString() {
        return "\nMedicamento: " + getMedicamento() + "\nDosis: " + getDosis() + "\nFrecuencia: " + getFrecuencia() + "\nVía: " + getVia();
    }

    
    
}
