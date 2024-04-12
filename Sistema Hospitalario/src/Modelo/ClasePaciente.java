/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
/* @author pablobasulto
 */
public abstract class  ClasePaciente  {

    //Atributos de la clase
    private String nombre;
    private int edad;
    private String genero;
    private String medico;
    private String patologias; 
    private int identificador;
   
    
    //Constructor:
    public ClasePaciente(String nombre, int edad, String genero, String medico, String patologias, int identificador) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.medico = medico;
        this.patologias = patologias;
        this.identificador = identificador;
 
    }
    
    //Getters:

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }
    
    public String getMedico(){
        return medico;
    }

    public String getPatologias() {
        return patologias;
    }

    public int getIdentificador() {
        return identificador;
    }
    
    //Setters:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setMedico(String medico){
        this.medico = medico;
    }

    public void setPatologias(String patologias) {
        this.patologias = patologias;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    
    public abstract String Ranking();
    
    
    @Override
    public String toString() {
        return "\nNombre: " + getNombre() + "\nEdad: " + getEdad() + "\nIdentificador: " + getIdentificador() + "\nPatologías: " + getPatologias() + "\nNivel de cuidado: " ;
    }
    
    
    
    
    
    
    
    

    
    

    
}
