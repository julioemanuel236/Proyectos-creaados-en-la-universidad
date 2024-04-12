package piezas;

import visual.Segmento;

public class PiezaI extends Pieza{

    private static boolean[][][] estados = {
                                                {
                                                    {true},
                                                    {true},
                                                    {true},
                                                    {true}
                                                },
                                                {
                                                     {true,true,true,true}
                                                }
                                           };
    
    public PiezaI(Segmento[][] matrix,int size) {
        super(matrix,estados,size);
    }

    
}
