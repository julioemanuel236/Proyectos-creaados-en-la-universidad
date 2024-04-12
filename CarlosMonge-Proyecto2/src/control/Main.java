/*
    Universiddad Estatal a Distancia
    Carlos Daniel Monge Centeno
    118630442

*/

package control;
import visual.MainWindow;
import visual.NuevoTransporteWindow;

public class Main {
    
    public static void main(String[] args){
        /*
            establecemos el look and feel con el estilo nimbus
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //creamos una instancia de nuestro controlador de datos
        Datos datos = new Datos();
        //creamos la ventana principal de nuestro programa
        new MainWindow(datos).setVisible(true);
    }
}
