package objetos;

import java.util.Random;

import juego.Juego;
import juego.Tablero;
public class Bomba extends Objeto {
	final int DX[]= {1,1,0,-1,-1,-1,0,1};
    final int DY[]= {0,1,1,1,0,-1,-1,-1};
    int DIR[];
    
	public Bomba(int x, int y,Tablero t) {
		super(x, y,t);
	}
	
	public int activar() {
		super.activar();	//activar de ojbeto	
		System.out.println(x+" "+y+" "+getClass());//mostrar que tipo de bomba soy
		Objeto obj = t.mapa[y][x];//coger el obj en mi posicion del mapa, puedo no ser yo
		if(obj.getClass()== Barco.class) {//si es un barco
			System.out.println("OBJETO");
			return obj.activar();//retornar el activar del barco
		}
		else {
			System.out.println(obj!=this);
			if(obj!=this) {//si no soy yo lo que está en el tablero
				//si es una bomba escribir activacion de la bomba
				if(obj instanceof Bomba)Juego.escribirAccion(t.jugador+",Activacion de "+getClass().getSimpleName()+" en "+x+"-"+y);
				//devolver el resultado de activar ojb
				return obj.activar();
			}
			System.out.println("Seleccionando Direccion de ataque");
			int dir=-1;
			try{
				dir = seleccionarDireccion(t);
			}
			catch(Exception e) {
				System.out.println("ASDASDSD");
			}
			System.out.println("Seleccione "+dir);
			if(dir==-1)return 0;
			int x=this.x;
			int y=this.y;
			int	puntos=0;
			while(t.posicionValida(x, y)) {//mientras no se salga del mapa
				
				obj = t.mapa[y][x];//obtener el objeto en mi posicion actual
				x+=DX[dir];
				y+=DY[dir];
				if(obj.activado)continue;	//omitir objetos activados	
				else puntos+=obj.activar();//acumular el resultado de activar 
				if(obj instanceof Bomba||obj instanceof Barco)return puntos;
			}
			return puntos;//retornar el resultado
		}
	}
	
	public int seleccionarDireccion(Tablero t) {
		//para seleccionar una direccion aleatoria para atacar
		if(DIR==null)return -1;//si dir esta vacio retornar -1
		int dir=-1;
		Random rand = new Random();
		boolean vi[] = {false,false,false,false};//iniciar que no he revisado niguna de las 4 posciones validas
		int visitados=0;//cantidad de visitados
		while(dir==-1) {//mientras no encuentre a donde ir
			if(visitados==4)return -1;//si viste las 4 y nada retornar -1
			int pos = rand.nextInt(4);//generar un numero aleatorio
			int temp = DIR[pos];//temp es la direccion a la que puedo ir
			System.out.println("BUSCANDO POSICOIN EN DIR "+temp+" "+t.posicionValida(x+DX[temp], y+DY[temp]));
			if(t.posicionValida(x+DX[temp], y+DY[temp]))dir=temp;//si la poscion es valida igualar
			if(!vi[pos]) {//si no la he visitado
				visitados++;//aumentar visitados
				vi[pos]=true;// y marcar como que la visite
			}
			
		}
		return dir;//retornar la direccion seleccionada
	}
}
