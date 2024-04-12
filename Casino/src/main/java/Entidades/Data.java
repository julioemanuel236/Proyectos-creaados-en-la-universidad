package Entidades;

import estructuras.Cola;


public class Data {

    private Cola proveedores;
    
    public Data(){
        proveedores = new Cola();
    }
    
    public Data(int n){
        proveedores = new Cola(n);
    }

    
    public boolean agregarProveedor(Proveedor p){
        return proveedores.add(p);
    }
    
    public Cola getProveedores() {
        return proveedores;
    }
                    
}
