
package Modelo;


public class FactoryPieza {
    
     public Pieza factoryMethod(Ttipo tipo, TColor color, int x, int y) {
        switch (tipo) {
            case Peon:
                return new Peon(color, x, y);
            case Torre:
                return new Torre(color, x, y);
            case Caballo:
                return new Caballo(color, x, y);
            case Alfil:
                return new Alfil(color, x, y);
            case Reina:
                return new Reina(color, x, y);
            case Rey:
                return new Rey(color, x, y);
            default:
                throw new IllegalArgumentException("Tipo de pieza desconocido: " + tipo);
        }
    }


}
