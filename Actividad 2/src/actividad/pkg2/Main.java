package actividad.pkg2;

public class Main {

    public static void main(String[] args){
        
        LibroDigital libroDigital = new LibroDigital("TITULO LIBRO DIGITAL","AUTOR 1",10);
        libroDigital.imprimirDetalles();
        libroDigital.leerEnLinea();
        libroDigital.descargar();

        LibroFisico libroFisico = new LibroFisico("TITULO LIBRO FISICO","AUTOR 2",20);
        libroFisico.imprimirDetalles();
        libroFisico.abrir();
        libroFisico.cerrar();   
        
    }
}
