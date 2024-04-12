package estructuras;

import Entidades.Proveedor;

public class Cola {
    Proveedor proveedores[];
    int size = 0;
    int actual = 0;
    int fin = 0;
    
    
    public Cola(){
        proveedores = new Proveedor[50];
    }
    
    public Cola(int n){
        proveedores = new Proveedor[n];
    }
    
    public boolean add(Proveedor proveedor){
        if(size == proveedores.length)
            return false;       
        
        
        proveedores[fin++] = proveedor;
        fin%=proveedores.length;
        size++;
        return true;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }           
    
    public Proveedor poll(){
        if(isEmpty())
            return null;
                
        Proveedor p = proveedores[actual];
        proveedores[actual] = null;
        actual++;
        size--;
        actual%=proveedores.length;
        
        return p;
    }
    
    public Proveedor peek(){
        return proveedores[actual];
    }
    
    public boolean pop(){
        if(isEmpty())return false;
        
        if(peek().getJuegos().isEmpty()){
            proveedores[actual] = null;
            actual++;
            size--;
            actual%=proveedores.length;
            return true;
        }
                    
        return false;
    }
    
    public int size(){
        return size;
    }
    
    public Proveedor[] getProveedores(){
        return proveedores;
    }

    public Proveedor get(int index) {
        int a = actual + index;                    
        a%=proveedores.length;                
        return proveedores[a];
    }

}
