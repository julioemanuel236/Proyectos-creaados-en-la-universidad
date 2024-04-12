package controlador;
import java.util.ArrayList;
import modelo.*;
import vista.Menu;

public class Control {
    ArrayList<Torneo> torneos = new ArrayList<>();
    vista.Menu menu;
    Torneo torneo;
    public void avanzarPartido(int id){
        Partido[][] partidos = torneo.getPartidos();
        for(int i=0;i<partidos.length;i++){
            for(int j=0;j<partidos[i].length;j++){
                if(partidos[i][j].getId()==id){
                    if(partidos[i][j].getEstado() == Partido.EN_ESPERA)return;
                    if(partidos[i][j].getEstado() == Partido.FINLALIZADO)return;
                    partidos[i][j].siguienteEstado();
                    System.out.println("Partido "+id+" "+partidos[i][j].estadoActual());
                    if(partidos[i][j].getEstado() == Partido.FINLALIZADO){
                        int op = menu.ganador(partidos[i][j]);
                        int k = i+1;
                        int p = 2;
                        int l = j/p;
                        if(k == partidos.length){
                            menu.finTorneo(torneo);
                            return;
                        }
                        while(partidos[k].length<=l){
                            System.err.println("FILA: "+k+" POSICION: "+l);
                            k++;
                            p*=2;
                            l/=p;
                        }
                        partidos[k][l].agregarJugador(partidos[i][j].getGanador());
                        //  System.err.println(partidos[i][j].getId()+" ASIGNADO A PARTIDO ID: "+partidos[k][l].getId());
                    }
                    return;
                }
            }
        }
        menu.mostrarError("No existe un partido con esa ID");
    }

    public boolean agregarTorneo(String nombre){
        for(Torneo i:torneos)
            if(i.getNombre().equalsIgnoreCase(nombre))return false;
        torneos.add(new Torneo(nombre));
        return true;
    }

    public String listaTorneos(){
        String s = "";
        int index=1;

        for(Torneo t:torneos){
            s += (index++)+"- "+t.getNombre()+"| Participantes: "+t.getCantidadParticipantes()+"\n";
        }

        return s;
    }

    public int getCantidadTorneos() {
        return torneos.size();
    }

    public void seleccionarTorneo(int index){
        this.torneo = torneos.get(index);
    }


    public String listaPartidos(){
        String s = "";
        Partido[][] partidos = torneo.getPartidos();
        for(int i=0;i<partidos.length;i++){
            for(int j = 0;j<partidos[i].length;j++){
                if(!partidos[i][j].finalizado())s+= partidos[i][j].getId()+"\n";
            }
        }
        return s;
    }
    public int getCantidadPartidos(){
        Partido[][] partidos = torneo.getPartidos();
        if(partidos==null)return 0;
        return (int)Math.pow(2,partidos.length);
    }

    public boolean comenzarTorneo(){
        if(torneo != null && !torneo.isRunning()){
            return torneo.crearPartidos();
        }
        return false;
    }

    public boolean agregarJugador(String nombre){
        if(torneo != null)torneo.agregarJugador(new Jugador(nombre,torneo.getCantidadParticipantes()+1));
        else return false;
        return true;
    }

    private String estado(int i,int j,int nivel){
        String salto = "";
        for(int k=0;k<nivel;k++)
            salto += "\t";
        Partido partido = torneo.getPartidos()[i][j];
        String resultado = salto+partido.toString() + "{\n";
        if(i==0){
            resultado += salto+"\t"+partido.getJugador1().toString()+"\n";
            resultado += salto+"\t"+partido.getJugador2().toString()+"\n";
        }
        else{
            resultado += estado(i-1,j*2,nivel+1)+
                         estado(i-1,(j*2)+1,nivel+1);
        }
        return resultado+salto+"}(fin resumen partido "+partido.getId()+")\n";
    }

    public String  generarEstado(){
        String estado = "";
        Partido[][] partidos = torneo.getPartidos();
        if( partidos == null){
            return "No existen partidos\n";
        }
        estado = estado(partidos.length - 1,0,0);

        return estado;
    }

    public String getParticipantes(int id){
        if(torneo == null)menu.mostrarError("No hay un torneo seleccionado");
        Partido[][] partidos = torneo.getPartidos();
        for(int i=0;i<partidos.length;i++)
            for(int j=0;j<partidos[i].length;j++)
                if(partidos[i][j].getId() == id)
                    return
                            partidos[i][j].getJugador1().toString()+"\n"+
                            partidos[i][j].getJugador2().toString()+"\n";

        return "No hay un partido con esa ID";
    }


    public Control(vista.Menu menu){
        this.menu = menu;
    }
}
