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
public class ClaseReporteInternado extends ClaseReportes{
    
    //Avance Enfermedad se medirá base al porcentaje (0-100)
    private int avanceEnfermedad;
    
    //Constructor:

    public ClaseReporteInternado(int avanceEnfermedad, ArrayList<ClaseRecetas> listaRecetas, ClaseFecha fecha, ClaseHora hora, String observacion) {
        super(listaRecetas, fecha, hora, observacion);
        this.avanceEnfermedad = avanceEnfermedad;
    }

    

    //Getter:
    public int getAvanceEnfermedad() {
        return avanceEnfermedad;
    }
    
    //Setter:

    public void setAvanceEnfermedad(int avanceEnfermedad) {
        this.avanceEnfermedad = avanceEnfermedad;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAvance de enfermedad: " + getAvanceEnfermedad();
    }
    
    
    
    
    
    
    

    

    
    
    
    

    

    
    
    
    
    
}
