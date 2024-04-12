package piezas;

import visual.Segmento;

public class PiezaO extends Pieza{
    private static boolean[][][] estados = {
                                                {
                                                    {true,true},
                                                    {true,true},                                                    
                                                }                                                
                                           };

    
    public PiezaO(Segmento[][] matrix,int size) {
        super(matrix, estados,size);
    }
    
}
