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
public class ClaseFecha {
    
    //Atributos:
    private int dia;
    private int mes;
    private int anio;
    
    //Constructor:

    public ClaseFecha(int dia, int mes, int anio) {
        setAnio(anio);
        setMes(mes);
        setDia(dia);
        
    }
    
    
        private ArrayList<Integer> Meses31Dias(){ 
        ArrayList<Integer> meses31Dias = new ArrayList();
        meses31Dias.add(1);
        meses31Dias.add(3);
        meses31Dias.add(5);
        meses31Dias.add(7);
        meses31Dias.add(8);
        meses31Dias.add(10);
        meses31Dias.add(12);
        
        return meses31Dias;
        }
    
    //Lista con las posiciones de los meses con 30 dias:
    private ArrayList<Integer> Meses30Dias(){ 
        ArrayList<Integer> meses30Dias = new ArrayList();
        meses30Dias.add(4);
        meses30Dias.add(6);
        meses30Dias.add(9);
        meses30Dias.add(11);
        
        return meses30Dias;
    }
    
    //Generar una lista de los días según el mes que se elija:
    private ArrayList<Integer> DiasDelMes(){
        ArrayList<Integer> DiasDelMes = new ArrayList();
        int inicio = 1; //Día donde se empezará a contar para el mes, por lógica este siempre será 1
        
        
        int fin = 0; // Dia final del mes puede ser 30, 31, 28 o 29
        
        boolean validador = false;  //Validar que el número que se ingresa se ubique en una lista  

        while (validador == false){
            
            if (getMes() == 2) //En caso de que se elija febrero
                {
                   if (getAnio() % 4 == 0){ 
                       fin = 29;  //En caso de ser año bisiesto
                      
                   }                
                   else {
                       fin = 28;
                   }
                   validador = true;
                   break;
                   
               }
            else {
            for (int elemento : Meses31Dias()){ //En caso de que se elija un mes con 31 días
                if (elemento == getMes()){
                    fin = 31;
                    validador = true; 
                    break;
                    } 
            }
            
            for (int elemento : Meses30Dias()){ //En caso de que se elija un mes con 30 días
                if (elemento == getMes()){
                fin = 30;
                validador = true;
                break;
               }  
                
            }   
        }
        }
        /*Una vez que se detecte el tipo de mes que pertenece el número ingresado
          se generará una lista con el número de días del mes*/
        for (int i = inicio; i <= fin; i ++){
            DiasDelMes.add(i);
        }
        
        return DiasDelMes;
        
        
    }
    

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
    
    public int getDia(){
        return dia;
    }
    
    //Setters:

  public void setDia(int dia){
        if (getMes() != 0){
            ArrayList<Integer> ListaDias = new ArrayList();
            ListaDias = DiasDelMes();
            boolean diaEncontrado = false;
            int i = 0;
            do{
                for (int elemento: ListaDias){
                    if(elemento == dia) {
                        this.dia = dia;
                        diaEncontrado = true;
                        break;
                    }
                    else{
                        this.dia = 0;
                        i ++;
                    }
                }
            }while(diaEncontrado != true && i <= ListaDias.size());
         
        }
        else{
            this.dia = 0;
        }
        
       
        
    }

    public void setMes(int mes) {
        if ( mes <= 0 || mes > 12){
        this.mes = 0;
        }
        else {
            this. mes = mes;
        }
    }
    

    public void setAnio(int anio) {
        if (anio < 0){
            this.anio = 0;
        }
        else{
            this. anio = anio;
        }
       
    }

    @Override
    public String toString() {
        return getAnio() + "/" + getMes() + "/" + getDia();
    }
    
    
    
    
    
}
