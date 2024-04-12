import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arbol<T> {
	
	private Arbol<T> hijoIzq,hijoDer;
	private T dato;

	public Arbol() {}
	
	public Arbol(T dato) {
		this.dato = dato;
	}
	
	public Arbol<T> getHijoIzquierdo(){
		return hijoIzq;
	}
	
	public Arbol<T> getHijoDerecho(){
		return hijoDer;
	}
	
	public void setHijoIzquierdo(Arbol<T> hijo) {
		this.hijoIzq = hijo;
	}
	
	public void setHijoDerecho(Arbol<T> hijo) {
		this.hijoDer = hijo;
	}
		
	public static void main(String args[]) {
		Arbol<Character> arbol = new Arbol<>('G');
		
		arbol.setHijoIzquierdo(new Arbol<Character>('E'));
		arbol.getHijoIzquierdo().setHijoIzquierdo(new Arbol<Character>('A'));
		arbol.getHijoIzquierdo().getHijoIzquierdo().setHijoIzquierdo(new Arbol<Character>('I'));
		arbol.getHijoIzquierdo().getHijoIzquierdo().setHijoDerecho(new Arbol<Character>('B'));
		
		arbol.setHijoDerecho(new Arbol<Character>('M'));
		arbol.getHijoDerecho().setHijoIzquierdo(new Arbol<Character>('C'));
		arbol.getHijoDerecho().setHijoDerecho(new Arbol<Character>('K'));
		
		arbol.getHijoDerecho().getHijoIzquierdo().setHijoIzquierdo(new Arbol<Character>('L'));
		arbol.getHijoDerecho().getHijoIzquierdo().setHijoDerecho(new Arbol<Character>('F'));
		
		arbol.getHijoDerecho().getHijoDerecho().setHijoDerecho(new Arbol<Character>('J'));
		
		arbol.getHijoDerecho().getHijoIzquierdo().getHijoIzquierdo().setHijoDerecho(new Arbol<Character>('D'));
		
		arbol.getHijoDerecho().getHijoDerecho().getHijoDerecho().setHijoIzquierdo(new Arbol<Character>('H'));
		
		System.out.println("Cantidad Nodos: "+cantidadNodos(arbol));
		System.out.println("Altura del arbol: "+altura(arbol));
		System.out.print("Recorrido Inorden: ");recorridoInorden(arbol);
		System.out.print("Recorrido PostOrden: ");recorridoPostOrden(arbol);
		
        char[] preoder = {'G', 'E', 'A', 'I', 'B', 'M', 'C', 'L', 'D', 'F', 'K', 'J', 'H'};
        char[] inorder = {'I', 'A', 'B', 'E', 'G', 'L', 'D', 'C', 'F', 'M', 'K', 'H', 'J'};

        List<Character> postorder = constructTree(preoder, inorder);

        System.out.println("Recorrido en postorden:");
        for (char ch : postorder) 
            System.out.print(ch + " ");	
	}
	
	public static int cantidadNodos(Arbol arbol) {
		int cant = 1;
		if(arbol.getHijoIzquierdo() != null)
			cant+= cantidadNodos(arbol.getHijoIzquierdo());
		if(arbol.getHijoDerecho() != null)
			cant+= cantidadNodos(arbol.getHijoDerecho());		
		return cant;
	}
	
	public static int altura(Arbol arbol) {		
		int a1 = 0,a2 = 0;
		if(arbol.getHijoIzquierdo() != null) {
			a1 = altura(arbol.getHijoIzquierdo());
			
		}
		if(arbol.getHijoDerecho()!=null) {
			a2 = altura(arbol.getHijoDerecho());			
		}
		
		return 1 + Math.max(a1, a2);
		
	}
	
	public static void recorridoInorden(Arbol arbol) {
	 List<Integer> recorrido = new ArrayList<>();
        Stack<Arbol> pila = new Stack<>();
        Arbol nodoActual = arbol;

        while (nodoActual != null || !pila.isEmpty()) {
            while (nodoActual != null) {
                pila.push(nodoActual);
                nodoActual = nodoActual.getHijoIzquierdo();
            }
            nodoActual = pila.pop();
            System.out.print(nodoActual.dato+" ");
            nodoActual = nodoActual.getHijoDerecho();
        }	
		System.out.println();
		
	}
			
	public static void recorridoPostOrden(Arbol arbol) {
        List<Integer> recorrido = new ArrayList<>();
        Stack<Arbol> pila = new Stack<>();
        Arbol nodoActual = arbol;
        Arbol ultimoVisitado = null;

        while (nodoActual != null || !pila.isEmpty()) {
            if (nodoActual != null) {
                pila.push(nodoActual);
                nodoActual = nodoActual.getHijoIzquierdo();
            } else {
                Arbol nodoTope = pila.peek();
                if (nodoTope.getHijoDerecho()!= null && nodoTope.getHijoDerecho()!= ultimoVisitado) {
                    nodoActual = nodoTope.getHijoDerecho();
                } else {
                    System.out.print(nodoTope.dato+" ");
                    ultimoVisitado = pila.pop();
                }
            }
        }
        System.out.println();
	}
	
	public static List<Character> constructTree(char[] preoder, char[] inorder) {
        List<Character> postorder = new ArrayList<>();
        constructTreeHelper(preoder, inorder, 0, preoder.length - 1, 0, inorder.length - 1, postorder);
        return postorder;
    }

    public static void constructTreeHelper(char[] preoder, char[] inorder, int preStart, int preEnd, int inStart, int inEnd, List<Character> postorder) {
        if (preStart > preEnd || inStart > inEnd) {
            return;
        }

        char root = preoder[preStart];
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }

        int leftSubtreeSize = rootIndex - inStart;
        int rightSubtreeSize = inEnd - rootIndex;

        constructTreeHelper(preoder, inorder, preStart + 1, preStart + leftSubtreeSize, inStart, rootIndex - 1, postorder);
        constructTreeHelper(preoder, inorder, preEnd - rightSubtreeSize + 1, preEnd, rootIndex + 1, inEnd, postorder);

        postorder.add(root);
    }

}
