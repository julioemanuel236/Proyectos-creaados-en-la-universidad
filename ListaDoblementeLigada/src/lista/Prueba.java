package lista;

import java.util.Random;
public class Prueba {

	public static void main(String[] args) {
		Random rand = new Random();
		ListaDoblementeLigada<Integer> lista = new ListaDoblementeLigada<>();
		for(int i=0 ;i<10 ;i++) {
			lista.insertarFinal(lista.getFin(), i);
			NodoListaDoblementeLigada<Integer> fin = lista.getFin();
		
			System.out.println("DATO DEL NODO :" +fin.getInfor());
			if(fin.getLigeIzq()!=null)
				System.out.println("LIGEIZQ DEL NODO :" +fin.getLigeIzq().getInfor());
			if(fin.getLigeDer()!=null)
			System.out.println("LIGEDER DEL NODO :" +fin.getLigeDer().getInfor());
		}
		
	}
}
