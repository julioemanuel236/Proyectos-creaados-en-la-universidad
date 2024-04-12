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
public class ClasePacienteInternado extends ClasePaciente {
    
    private ArrayList<ClaseActividades> itinerario;
    private ArrayList<ClaseReportes> listaReportes;

    public ClasePacienteInternado(ArrayList<ClaseActividades> itinerario, ArrayList<ClaseReportes> listaReportes, String nombre, int edad, String genero, String medico, String patologias, int identificador) {
        super(nombre, edad, genero, medico, patologias, identificador);
        this.itinerario = itinerario;
        this.listaReportes = listaReportes;
    }
    
    

    
    //Getter:
    public ArrayList getItinerario() {
        return itinerario;
    }

    public ArrayList<ClaseReportes> getListaReportes() {
        return listaReportes;
    }
    
    
    //Setter:
    public void setItinerario(ArrayList itinerario) {
        this.itinerario = itinerario;
    }

    public void setListaReportes(ArrayList<ClaseReportes> listaReportes) {
        this.listaReportes = listaReportes;
    }
    
    
    
    public String Ranking(){
        //Contador llevará los puntos que acumula el paciente por cada parámetro tomado en cuena
        int contador = 1;
        //Si el paciente tiene más de 60 años o sufre alguna patología:
        if (getEdad() >= 60 || getPatologias().equals("N/A") == false){
            contador += 1; 
        }
        else{
            contador += 0;
        }
        //El avance de la enfermedad del paciente según el último reporte:
        
        for (int i = 0; i < getListaReportes().size(); i++){
            if (getListaReportes().get(i) instanceof ClaseReporteInternado){
                ClaseReporteInternado reporteConsulta = (ClaseReporteInternado) getListaReportes().get(i);
                
                if (reporteConsulta.getAvanceEnfermedad() >= 80){
                    contador += 3; 
                }
                else if (reporteConsulta.getAvanceEnfermedad() >= 50 && reporteConsulta.getAvanceEnfermedad() < 80){
                    contador += 2;
                }
                else if (reporteConsulta.getAvanceEnfermedad() >= 25 && reporteConsulta.getAvanceEnfermedad() < 50){
                    contador += 1;
                }
                else{
                    contador += 0;
                }
            }    
        }
        //Si es que el paciente a tenido alguna cirugia y de ser así se toma el nivel de la complejidadde esta:
        for (int i = 0; i < getListaReportes().size(); i ++){
            if (getListaReportes().get(i) instanceof ClaseReporteQuirurjico){
                contador += 1;
                ClaseReporteQuirurjico reporteQuirurjico = (ClaseReporteQuirurjico) getListaReportes().get(i);
                if(reporteQuirurjico.complejidad >5 ){
                    contador += 2; 
                }
            }
            else {
                contador += 0;
            }
        }
        if (contador <= 2 ){
            return "Bajo";
        }
        else if(contador > 2 && contador <= 4){
            return "Intermedio";
        }
        else if(contador > 4 && contador <=6 ){
            return "Alto";
        }
        else {
            return "Muy Alto";
        }
            
    }

    
    
    
}
