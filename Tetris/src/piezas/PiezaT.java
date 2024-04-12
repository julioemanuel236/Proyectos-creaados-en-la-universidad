package piezas;

import visual.Segmento;

public class PiezaT extends Pieza{
    private static boolean[][][] estados = {
                                                {
                                                    {true,true,true},
                                                    {false,true,false}                                                    
                                                },
                                                {
                                                     {false,true},
                                                     {true,true},
                                                     {false,true}
                                                },
                                                {
                                                    {false,true,false},
                                                    {true,true,true}
                                                },
                                                {
                                                    {true,false},
                                                    {true,true},
                                                    {true,false}
                                                }
                                           };
    public PiezaT(Segmento[][] matrix,int size) {
        super(matrix, estados,size);
    }
    
}
