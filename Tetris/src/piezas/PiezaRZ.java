package piezas;

import visual.Segmento;

public class PiezaRZ extends Pieza{
        private static boolean[][][] estados = {
                                                {
                                                    {false,true,true},                                                                                                   
                                                    {true,true,false}
                                                    
                                                },
                                                {
                                                    {true,false},
                                                    {true,true},
                                                    {false,true}
                                                     
                                                }
                                           };

    public PiezaRZ(Segmento[][] matrix,int size) {
        super(matrix, estados,size);
    }    
    
}
