package actividad.pkg2.pkg2;
import java.util.Scanner;

public class Actividad22 {

    private String[] nombresCompetidores;
    private double[] tiemposCompetidores;
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;
        boolean salir = false;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar datos de los competidores");
            System.out.println("2. Mostrar datos");
            System.out.println("3. Ordenar datos");
            System.out.println("4. Buscar dato");
            System.out.println("5. Mostrar al ganador");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    ingresarDatosCompetidores();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    ordenarDatos();
                    break;
                case 4:
                    buscarDato();
                    break;
                case 5:
                    mostrarGanador();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción del menú.");
                    break;
            }
        } while (!salir);
    }

    public void buscarDato() {
        System.out.print("NOMBRE A BUSCAR:");
        String nombre = scanner.nextLine();
        
        for(int i=0;i<nombresCompetidores.length;i++){
            if(nombre.toLowerCase().equals(nombresCompetidores[i].toLowerCase())){
                System.out.println("NOMBRE: "+nombre);
                System.out.println("TIEPMO: "+tiemposCompetidores[i]);
                return;
            }
        }
    }

    public void ingresarDatosCompetidores() {
        System.out.print("Ingrese la cantidad de competidores: ");
        int cantidadCompetidores = Integer.parseInt(scanner.nextLine());

        nombresCompetidores = new String[cantidadCompetidores];
        tiemposCompetidores = new double[cantidadCompetidores];

        for (int i = 0; i < cantidadCompetidores; i++) {            
            System.out.print("Ingrese el nombre del competidor " + (i + 1) + ": ");
            nombresCompetidores[i] = scanner.nextLine();
            System.out.print("Ingrese el tiempo del competidor " + (i + 1) + ": ");
            tiemposCompetidores[i] = Double.parseDouble(scanner.nextLine());
        }
    }

    public void mostrarDatos() {
        System.out.println("\nDatos de los competidores:");
        System.out.println("Nombres\t\tTiempos");
        for (int i = 0; i < nombresCompetidores.length; i++) {
            System.out.println(nombresCompetidores[i] + "\t\t" + tiemposCompetidores[i]);
        }
    }

    public void ordenarDatos() {
        //Utilizando el ordenamiento burbuja para mantener la relacion tiempo-nombre
        for(int i=1;i<nombresCompetidores.length;i++){
            for(int k=0;k<nombresCompetidores.length;k++){
                int j = i-1;
                //si el tiempo d
                if(tiemposCompetidores[i]<tiemposCompetidores[j]){
                    double tiempoTemporal = tiemposCompetidores[i];
                    tiemposCompetidores[i] = tiemposCompetidores[j];
                    tiemposCompetidores[j] = tiempoTemporal;
                    
                    String nombreTemporal = nombresCompetidores[i];
                    nombresCompetidores[i] = nombresCompetidores[j];
                    nombresCompetidores[j] = nombreTemporal;
                }
            }
        
        }
        System.out.println("ARREGLO ORDENADO");                
        
    }

    public void mostrarGanador() {        
        int pos = 0;
        for(int i=0;i<nombresCompetidores.length;i++)
            if(tiemposCompetidores[i]<tiemposCompetidores[pos])
                pos = i;                            
                
        System.out.println("GANADOR");
        System.out.println("NOMBRE: "+nombresCompetidores[pos]);
        System.out.println("TIEMPO:"+tiemposCompetidores[pos]);
    }

    public static void main(String[] args) {
        Actividad22 competencia = new Actividad22();
        competencia.menu();
    }

}
