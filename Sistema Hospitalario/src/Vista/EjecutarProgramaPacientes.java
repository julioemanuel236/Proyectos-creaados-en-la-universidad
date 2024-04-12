/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;
import Modelo.ClasePaciente;
import Modelo.ClasePacienteConsulta;
import Modelo.ClasePacienteInternado;
import java.util.ArrayList;

/**
 *
 * @author pablobasulto
 */
public class EjecutarProgramaPacientes {
    //Listas para claseificar a los pacientes:
    public static ArrayList<ClasePacienteConsulta> listaPacienteConsulta = new ArrayList<ClasePacienteConsulta>();
    public static ArrayList<ClasePacienteInternado> listaPacienteInternado = new ArrayList<ClasePacienteInternado>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Ventana1().setVisible(true);
    }
    
}
