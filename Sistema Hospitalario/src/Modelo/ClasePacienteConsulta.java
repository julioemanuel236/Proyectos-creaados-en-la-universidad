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
public class ClasePacienteConsulta extends ClasePaciente {
    private ArrayList<ClaseReportes> listaReportes;
    public ClasePacienteConsulta(String nombre, int edad, String genero, String medico, String patologias, int identificador, ArrayList<ClaseReportes> listaReportes) {
        super(nombre, edad, genero, medico, patologias, identificador);
        this.listaReportes = listaReportes;
    }

    public ArrayList<ClaseReportes> getListaReportes() {
        return listaReportes;
    }

    public void setListaReportes(ArrayList<ClaseReportes> listaReportes) {
        this.listaReportes = listaReportes;
    }
    
    
    
    public String Ranking(){
        if (getPatologias().equals("N/A") && getEdad() <= 60){
            return "Bajo";
        }
        else return "Intermedio";
    }
  
    
}
    

