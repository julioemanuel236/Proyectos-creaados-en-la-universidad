package test;


import vista.Menu;
import modelo.*;

import static org.junit.Assert.*;
import org.junit.Test;
class tpvTest {

    @Test
    void estructura1(){
        Torneo t= new Torneo("t");
        for(int i=0;i<2;i++)
            t.agregarJugador(new Jugador("jugador",i));
        t.crearPartidos();
        String s = "";
        Partido[][] partidos = t.getPartidos();
        for(int i=0;i<partidos.length;i++){
            for(int j=0;j<partidos[i].length;j++){
                s += partidos[i][j].getId()+" ";
            }
                s+="\n";
        }
        assertEquals("1 \n",s);
    }

    @Test
    void estructura2(){
        Torneo t= new Torneo("T");
        for(int i=0;i<4;i++)
            t.agregarJugador(new Jugador("jugador",i));
        t.crearPartidos();
        String s = "";
        Partido[][] partidos = t.getPartidos();
        for(int i=0;i<partidos.length;i++){
            for(int j=0;j<partidos[i].length;j++){
                s += partidos[i][j].getId()+" ";
            }
            s+="\n";
        }
        assertEquals ("1 2\n3 ",s);
    }

    @Test
    void estructura3(){
        Torneo t= new Torneo("#");
        for(int i=0;i<8;i++)
            t.agregarJugador(new Jugador("jugador",i));
        t.crearPartidos();
        String s = "";
        Partido[][] partidos = t.getPartidos();
        for(int i=0;i<partidos.length;i++){
            for(int j=0;j<partidos[i].length;j++){
                s += partidos[i][j].getId()+" ";
            }
            s+="\n";
        }
        assertEquals ("1 2 3 4 \n5 6 \n7 ",s);
    }

    @Test
    void estructura4(){
        Torneo t= new Torneo("T");
        Menu menu = new Menu();
        for(int i=0;i<5;i++)
            t.agregarJugador(new Jugador("jugador",i));
        t.crearPartidos();
        String s = "";
        Partido[][] partidos = t.getPartidos();
        for(int i=0;i<partidos.length;i++){
            for(int j=0;j<partidos[i].length;j++){
                s += partidos[i][j].getId()+" ";
            }
            s+="\n";
        }
        assertEquals ("",s);
    }

    public static void main(String[] args){

    }
}