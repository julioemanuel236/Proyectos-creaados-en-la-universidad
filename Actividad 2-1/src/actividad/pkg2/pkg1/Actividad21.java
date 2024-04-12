package actividad.pkg2.pkg1;

public class Actividad21 {
  public static void main(String[] args) {
        // a. Declaración del arreglo unidimensional
        int[] vectorA;
        int[] vectorB;

        // b. Declaración del arreglo multidimensional
        int[][] matriz = new int[7][7];

        // c. Creación de la instancia del arreglo unidimensional
        vectorA = new int[7];
        vectorB = new int[7];

        // e. Llenado del arreglo multidimensional
        llenarMatriz(matriz);

        // f. Llenado del arreglo unidimensional y cálculo de sumas
        calcularSumas(matriz, vectorA, vectorB);

        // g. Impresión del contenido de la matriz y los arreglos unidimensionales
        System.out.println("Matriz generada:");
        imprimirMatriz(matriz);

        System.out.println("Suma por filas (Vector A):");
        imprimirVector(vectorA);

        System.out.println("Suma por columnas (Vector B):");
        imprimirVector(vectorB);
    }

    // e. Llenado del arreglo multidimensional
    public static void llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 100); // Valores aleatorios del 0 al 99
            }
        }
    }

    // f. Llenado del arreglo unidimensional y cálculo de sumas
    public static void calcularSumas(int[][] matriz, int[] vectorA, int[] vectorB) {
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
                sumaColumna += matriz[j][i]; // Se invierten los índices para sumar por columnas
            }
            vectorA[i] = sumaFila;
            vectorB[i] = sumaColumna;
        }
    }

    // g. Impresión del contenido de la matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // g. Impresión del contenido de un vector unidimensional
    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}
