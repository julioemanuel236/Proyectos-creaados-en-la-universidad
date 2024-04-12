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
public class ClaseReporteConsulta extends ClaseReportes{

    private String motivoConsulta;
    
    public ClaseReporteConsulta(String motivoConsulta, ArrayList<ClaseRecetas> listaRecetas, ClaseFecha fecha, ClaseHora hora, String observacion) {
        super(listaRecetas, fecha, hora, observacion);
        this.motivoConsulta = motivoConsulta;
        
    }

    //Getter:
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    
    //Setter:
    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    
    
    
    
    
    
    
    
    
}
