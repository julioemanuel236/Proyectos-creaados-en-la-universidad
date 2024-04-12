package piezas;

import visual.Segmento;

public class PiezaL extends Pieza{
    
    private static boolean[][][] estados = {
                                                {
                                                    {true,false},
                                                    {true,false},
                                                    {true,true}                                                    
                                                },
                                                {
                                                     {true,true,true},
                                                     {true,false,false},
                                                     
                                                },
                                                {
                                                    {true,true},
                                                    {false,true},
                                                    {false,true}
                                                },
                                                {
                                                    {false,false,true},
                                                    {true,true,true}                                                    
                                                }
                                           };

    
public PiezaL(Segmento[][] matrix,int size) {
        super(matrix, estados,size);
    }

    

}
