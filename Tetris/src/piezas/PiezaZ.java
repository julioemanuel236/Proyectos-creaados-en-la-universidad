package piezas;

import visual.Segmento;

public class PiezaZ extends Pieza{
        private static boolean[][][] estados = {
                                                {
                                                    {true,true,false},
                                                    {false,true,true}                                                                                                   
                                                },
                                                {
                                                    {false,true},
                                                    {true,true},
                                                    {true,false}
                                                     
                                                }
                                           };

    public PiezaZ(Segmento[][] matrix,int size) {
        super(matrix, estados,size);
    }
        
        
}
