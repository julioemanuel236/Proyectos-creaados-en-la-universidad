package lista;

public class Lista {   
    private Nodo cabeza;
    
    public Lista(){
        
    }
    
    public Nodo getCabeza(){
        return cabeza;
    }
    
    public void insertar(int id,String nombre){
        //aqui se iserta un partido nuevo con sus datos
        //se crea el nodo nuevo
        Nodo nodo = new Nodo(id,nombre);
        
        
        //si la cabeza es null es pq la lista esta vacia
        //en ese caso solo lo ponemos de cabeza
        if(cabeza == null){
            cabeza = nodo;
            return;
        }
        
        
        //para recorre necesitaremos el puntero actual
        //y el anterior
        Nodo puntero = cabeza;
        Nodo anterior = null;
        //mientras que no sea null
        //osea mientras no llege al final de lista
        
        while(puntero != null){
            //si el id del que estoy insertando es mayor que el puntero
            //ahi es donde debo insertarlo
            if(nodo.getID() > puntero.getID()){
                //entonces si anterior es null es pq puntero esta en la cabeza
                if(anterior == null){
                    //asi que actualizo el siguiente del nodo que sera la cabeza
                    nodo.setSiguiente(cabeza);
                    //y la cabeza ahora sera el nodo
                    cabeza = nodo;                   
                    return;
                }
                
                //en caso de que no sea null el anterior es que estoy en medio
                //asi que digo que el siguiente del nodo sera el siguiente del anterior
                //y que el siguiente del anterior ahora sera el nodo
                //asi logro insertar en el medio y mantener el orden
                nodo.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(nodo);
                return;
            }
            
            //en caso de que no se inserte digo que el anterior sera el
            //puntero que acabo de mirar
            //y el puntero sera el siguiente
            anterior = puntero;
            puntero = puntero.getSiguiente();
        }
        
        //en caso de no insertar nunca significa
        //que debe ir al final pq es la menor id
        //asi que lo inserte de siguiente de anterior
        //ya que en anteriro quedo el ultimo nodo
        anterior.setSiguiente(nodo);
    }
    
}
