package modelo;

public class Partido {
    public static int EN_ESPERA=0,PREPARADO=1,EN_JUEGO=2,FINLALIZADO=3;
    private static String ESTADOS[] = {"en espera","no jugado","en juego","finalizado"};
    private Jugador p1;
    private Jugador p2;
    private int id;
    private boolean ganador=false;
    private int estado = 0;

    public Partido(){

    }

    public Partido(int id){
        this.id=id;
    }

    public Partido(Jugador p1,int id){
        this.id=id;
        this.p1=p1;
    }
    public Partido(Jugador p1, Jugador p2, int id){
        this.p1=p1;
        this.p2=p2;
        this.id=id;
        siguienteEstado();
    }

    public String estadoActual(){
        return ESTADOS[estado];
    }

    public int getEstado(){
        return estado;
    }

    public void siguienteEstado(){
        if(getJugador2() == null || getJugador1() == null)return;
        if(estado<3)estado++;
    }

    public Jugador getGanador(){
        if(estado==3)return (ganador?p1:p2);
        return null;
    }

    public int getId(){
        return id;
    }

    public void agregarJugador(Jugador j){
        if(p1 != null && p2 != null)return;
        if(p1 == null)p1 = j;
        else if(p2 == null)p2 = j;
        if(p1 != null && p2 != null)siguienteEstado();
    }

    public String gameInfo(){
        switch(estado){
            case 1,2:return "entre jugador "+p1.getId()+ " y jugador" +p2.getId();
            case 3:return "entre jugador "+p1.getId()+ " y jugador" +p2.getId()+", ganador Jugador "+getGanador().getId();
            default: return "";
        }
    }

    public Jugador getJugador1(){
        return p1;
    }

    public Jugador getJugador2(){
        return p2;
    }

    public boolean finalizado(){
        return estado == FINLALIZADO;
    }

    @Override
    public String toString() {
        return "Partido "+id+": "+estadoActual()+", "+gameInfo()+", Predecesores";
    }

}
