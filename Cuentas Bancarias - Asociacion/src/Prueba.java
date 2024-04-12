import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        System.out.print("Nombre del cliente: ");
        String nombre = entry.nextLine();
        System.out.print("Documento del cliente: ");
        String documento = entry.nextLine();

        Cliente cliente = new Cliente(nombre, documento);

        while (true){
            System.out.println("MENU:");

            System.out.println("1-Consignar Cuenta 1");
            System.out.println("2-Consignar Cuenta 2");
            System.out.println("3-Retirar Cuenta 1");
            System.out.println("4-Retirar Cuenta 2");
            System.out.println("5-Consultar Cuenta 1");
            System.out.println("6-Consultar Cuenta 2");
            System.out.println("7-Saldo Total");
            System.out.println("0-Salir");

            int op = Integer.parseInt(entry.nextLine());

            switch(op){
                case 1:{
                    System.out.print("Cuanto saldo desea consginar: ");
                    int saldo = Integer.parseInt(entry.nextLine());
                    if(saldo<1){
                        System.out.println("No pude ser saldo negativo ni 0");
                    }
                    else cliente.consignarCuenta1(saldo);
                }break;
                case 2:{
                    System.out.print("Cuanto saldo desea consginar: ");
                    int saldo = Integer.parseInt(entry.nextLine());
                    if(saldo<1){
                        System.out.println("No pude ser saldo negativo ni 0");
                    }
                    else cliente.consignarCuenta2(saldo);
                }break;
                case 3:{
                    System.out.print("Cuanto saldo desea retirar: ");
                    int saldo = Integer.parseInt(entry.nextLine());
                    if(saldo<1){
                        System.out.println("No pude ser saldo negativo ni 0");
                    }
                    else {
                        if(cliente.retirarCuenta1(saldo))
                            System.out.println("Retiro exitoso");
                        else System.out.println("No dispone de esa cantidad");
                    }
                }break;
                case 4:{
                    System.out.print("Cuanto saldo desea retirar: ");
                    int saldo = Integer.parseInt(entry.nextLine());
                    if(saldo<1){
                        System.out.println("No pude ser saldo negativo ni 0");
                    }
                    else {
                        if (cliente.retirarCuenta2(saldo))
                            System.out.println("Retiro exitoso");
                        else System.out.println("No dispone de esa cantidad");
                    }
                }break;
                case 5:{
                    System.out.println("El saldo de la cuenta 1 es: "+cliente.consultarCuenta1());
                }break;
                case 6:{
                    System.out.println("El saldo de la cuenta 2 es: "+cliente.consultarCuenta2());
                }break;
                case 7:{
                    System.out.println("El saldo total del que dispone es de: "+cliente.saldoTotal());
                }break;

                case 0:return;
            }


        }

    }
}
