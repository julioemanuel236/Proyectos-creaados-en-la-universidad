package package_prueba;

import java.io.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Cliente_Residencial extends Cliente{
	boolean matutino;
	boolean rastreo;
	String hora;
	
	
	
	Cliente_Residencial(String n,String c,String d,String t,boolean can,boolean m,boolean r){
		super(n,c,d,t,can);
		matutino=m;
		rastreo=r;
	}
	
	String hora_despertar() {
		return telefono +((Integer.parseInt(hora.substring(0, 2))%13)+1)+":"+((Integer.parseInt(hora.substring(3))%60));
	}
	
	void fichero_hora() {
		FileWriter fw;
		
		try {
			fw = new FileWriter("Matituno_"+telefono+".txt");
			fw.write(hora_despertar());
			fw.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL GENERAR EL FICHERO MATUTINO.TXT");
		}
		
	}
	
	float pago() {
		float pago=0;
		for(Llamada_Internacional i :this.llamadasInter) {
			int horat = i.fecha.getHours();
			pago += i.minutos*(i.tarifa+(horat>=17||horat<11?0.5f:0));
		}
		
		for(Llamada_Interprovincial i :this.llamadasProvi) {
			int horat = i.fecha.getHours();
			float temp=i.minutos*
						(Math.abs(
						Integer.parseInt(i.formatear(i.saliente)[2])-
						Integer.parseInt(i.formatear(i.entrante)[2])
						)+(horat>=17||horat<11?0.5f:0));
			
			pago += temp;
		}
		int min = 0;
		for(Llamada i :this.llamadas) {
			 min += i.minutos;
		}
	
		return pago+(min>300?(min-300)*0.05f:0)+(matutino?1:0)+(rastreo?1:0);
	}
	
}


