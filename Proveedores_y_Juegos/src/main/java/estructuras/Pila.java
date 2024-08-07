package estructuras;

import Entidades.Juego;


public class Pila {
    private Juego[] juegos;
    private int size = 0;
    private int actual = 0;
            
            
    public Pila(){
        juegos = new Juego[50];
    }
    
    public Pila(int n){
        juegos = new Juego[n];
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return actual == 0;
    }
    
    public boolean add(Juego juego){
        if( size == juegos.length ){
            return false;
        }
        juegos[actual++] = juego;        
        size++;
        return true;
    }
    
    public Juego poll(){
        if(isEmpty())
            return null;
        actual--;
        size--;
        return juegos[actual];
    }
    
    public Juego peek(){
        if(isEmpty())
            return null;        
        return juegos[actual-1];
    }

    public Juego[] getJuegos(){
        return juegos;
    }
}


