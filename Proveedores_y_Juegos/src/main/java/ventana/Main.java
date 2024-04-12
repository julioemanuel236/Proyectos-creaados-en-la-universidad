package ventana;

import Entidades.Juego;
import estructuras.Pila;

public class Main {
    
    public static void main(String[] args){
        Pila q = new Pila();
        while(true){
            
            Juego j = new Juego();
            q.add(j);
            System.out.println(q.poll().getDni());
            
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                
            }
            
        }
    }
    
}