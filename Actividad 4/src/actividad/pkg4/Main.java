package actividad.pkg4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;        
        Paquete paquete = null;
        do {
            System.out.println("Menú Te llevo Todo");
            System.out.println("1.-Envio nacional");
            System.out.println("2.-Envio internacional");
            System.out.println("3.-Impresión de los datos del envío");
            System.out.println("4.-Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1:{                  

                    // Solicitamos los datos del envío
                    System.out.print("Peso: ");
                    double peso = Double.parseDouble(scanner.nextLine());
                    System.out.print("Largo: ");
                    double largo = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ancho: ");
                    double ancho = Double.parseDouble(scanner.nextLine());
                    System.out.print("Alto: ");
                    double alto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Lugar de envío: ");
                    String lugarEnvio = scanner.nextLine();
                    System.out.print("Nombre del remitente: ");
                    String nombreRemitente = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Nombre del destinatario: ");
                    String nombreDestinatario = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccionDestinatario = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoDestinatario = scanner.nextLine();   
                    paquete = new PaqueteNacional(peso, alto, ancho, largo, direccionDestinatario);
                    
                }                    
                    break;
                case 2:
                {                     
                    // Solicitamos los datos del envío
                    System.out.print("Peso: ");
                    double peso = Double.parseDouble(scanner.nextLine());
                    System.out.print("Largo: ");
                    double largo = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ancho: ");
                    double ancho = Double.parseDouble(scanner.nextLine());
                    System.out.print("Alto: ");
                    double alto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Lugar de envío: ");
                    String lugarEnvio = scanner.nextLine();
                    System.out.print("Nombre del remitente: ");
                    String nombreRemitente = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Nombre del destinatario: ");
                    String nombreDestinatario = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccionDestinatario = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoDestinatario = scanner.nextLine();   
                    paquete = new PaqueteInternacional(peso, alto, ancho, largo, direccionDestinatario);
                    
                }
                    break;
                case 3:
                    // Imprimimos los datos del envío
                    if (paquete != null) {
                        System.out.println("Peso: " + paquete.peso);
                        System.out.println("Dimensiones: " + paquete.largo + " x " + paquete.ancho + " x " + paquete.alto);
                        System.out.println("Destino: " + paquete.destino);
                        System.out.println("Costo de envío: " + paquete.calcularCostoEnvio());
                    } else {
                        System.out.println("No se ha creado ningún paquete.");
                    }

                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
            
            
            
        } while (opcion != 4);

        scanner.close();
    }
}
