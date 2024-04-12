package piezas;

import visual.Segmento;

public class PiezaRL extends Pieza{
    private static boolean[][][] estados = {
                                                {
                                                    {false,true},
                                                    {false,true},
                                                    {true,true}                                                    
                                                },
                                                {
                                                    {true,false,false},
                                                    {true,true,true}                                                                                                          
                                                },
                                                {
                                                    {true,true},
                                                    {true,false},
                                                    {true,false}
                                                },
                                                {
                                                    {true,true,true},
                                                    {false,false,true},                                                                                                        
                                                }
                                           };    

    public PiezaRL(Segmento[][] matrix,int size) {
        super(matrix, estados,size);
    }

    
}
