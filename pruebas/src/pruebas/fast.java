package pruebas;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class fast 
{
	public static String nombre,apellidopaterno,apellidomaterno,años,mes,dia,sexo,estado,telefono,telefono_guiones="",mes3;
	public static boolean a;
	public static int devolver,numero=0,numero1=0,edad=0,años1,dia1,mes1,años2,mes2,estado2,numero2=0,calcularedad;     

	
	public static void main (String[] arg)
	{
		numero=0;
		numero1=0;
		numero2=0; 
		edad=0;
		int opcion=0;
		
		
		System.out.flush();
		do
		{
		
		nombre();
		apellidopaterno();
		apellidomaterno();
		
		
		sexo = (JOptionPane.showInputDialog(null, "Seleccione su sexo: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"HOMBRE","MUJER"}, "Seleccion de sexo")).toString();
		
		if("HOMBRE".equals(sexo))
		{
			estado = (JOptionPane.showInputDialog(null, "Elige tu estado: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aguascalientes","Baja California","Baja California Sur","Campeche","Coahuila","Colima","Chiapas","Chihuahua","Durango","Distrito Federal","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de mexico","Michoacan","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla","Queretaro","Quintana Roo","San Luis Potosil","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatan","Zacatecas"}, "Elige tu estado")).toString();
			
			años = (JOptionPane.showInputDialog(null, "Elige tu años: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"}, "Selecciona tu años")).toString();			
            
			mes = (JOptionPane.showInputDialog(null, "Elige tu mes: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12"}, "Selecciona tu mes")).toString();
			
			if("01".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();
			}
			
			if("02".equals(mes))
			{
				años1();	
				
				if( (años1==1972) || (años1==1976) || (años1==1980) || (años1==1984) || (años1==1988) || (años1==1992) || (años1==1996) || (años1==2000) || (años1==2004) || (años1==2008) || (años1==2012) || (años1==2016) || (años1==2020))
				{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"}, "Selecciona dia")).toString();	
				}
				
				else if( (años1==1970) || (años1==1971) || (años1==1973) || (años1==1974) || (años1==1975) || (años1==1977) || (años1==1978) || (años1==1979) || (años1==1981) || (años1==1982) || (años1==1983) || (años1==1985) || (años1==1986) || (años1==1987) || (años1==1989) || (años1==1990) || (años1==1991) || (años1==1993) || (años1==1994) || (años1==1995) || (años1==1997) || (años1==1998) || (años1==1999) || (años1==2001) || (años1==2002) || (años1==2003) || (años1==2005) || (años1==2006) || (años1==2007) || (años1==2009) || (años1==2010) || (años1==2011) || (años1==2013) || (años1==2014) || (años1==2015) || (años1==2017) || (años1==2018) || (años1==2019) || (años1==2021) || (años1==2022) || (años1==2023))
				{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"}, "Selecciona dia")).toString();	
				}
			}
				
			if("03".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("04".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("05".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("06".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("07".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("08".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("09".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("10".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();
			}
				
			if("11".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("12".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				                            
                                               
            String c1Y2 = apellidopaterno.substring(0,1);
            String c1Y3 = apellidopaterno.substring(1,2);
			char c3 = apellidomaterno.charAt(0);
			char c4 = nombre. charAt(0);
			String c5Y6 = años.substring(2,3);
			String c5Y7 = años.substring(3,4);//
			String c7Y8 = mes.substring(0);
	   		String c9Y10 = dia.substring(0);	        
	   		char c11 = sexo.charAt(0);
	        char c14 = apellidopaterno.charAt(2);
	        char c15 = apellidomaterno.charAt(2);
	        char c16 = nombre.charAt(2);
            String c12Y13 = "ho";
			
	    	if (estado=="Aguascalientes")
	    	{
	        	c12Y13 = "AS";
	        }
	        else if (estado=="Baja California")
	        {
	        	c12Y13 = "BC";
	        }
	        else if (estado=="Baja California Sur")
	        {
	        	c12Y13 = "BS";
	        }
	        else if (estado=="Campeche")
	        {
	        	c12Y13 = "CC";
	        }
	        else if (estado=="Coahuila")
	        {
	        	c12Y13 = "CL";
	        }
	        else if (estado=="Colima")
	        {
	        	c12Y13 = "CM";
	        }
	        else if (estado=="Chiapas")
	        {
	        	c12Y13 = "CS";
	        }
	        else if (estado=="Chiuahua")
	        {
	        	c12Y13 = "CH";
	        }
	        else if (estado=="Distrito Federal")
	        {
	        	c12Y13 = "DF";
	        }
	        else if (estado=="Durango")
	        {
	        	c12Y13 = "DG";
	        }
	        else if (estado=="Guanajuato")
	        {
	        	c12Y13 = "GT";
	        }
	        else if (estado=="Guerrero")
	        {
	        	c12Y13 = "GR";
	        }
	        else if (estado=="Hidalgo")
	        {
	        	c12Y13 = "HG";
	        }
	        else if (estado=="Jalisco")
	        {
	        	c12Y13 = "JC";
	        }
	        else if (estado=="Estado de mexico")
	        {
	        	c12Y13 = "MC";
	        }
	        else if (estado=="Michoacan")
	        {
	        	c12Y13 = "MN";
	        }
	        else if (estado=="Morelos")
	        {
	        	c12Y13 = "MS";
	        }
	        else if (estado=="Nayarit")
	        {
	        	c12Y13 = "NT";
	        }
	    	else if (estado=="Nuevo Leon")
	    	{
	        	c12Y13 = "NL";
	        }
	      	else if (estado=="Oaxaca")
	      	{
	        	c12Y13 = "OC";
	        }
	        else if (estado=="Puebla")
	        {
	        	c12Y13 = "PL";
	        }
	       	else if (estado=="Queretaro")
	       	{
	        	c12Y13 = "QT";
	        }
	        else if (estado=="Quintana Roo")
	        {
	        	c12Y13 = "QR";
	        }
	        else if (estado=="San Luis Potosil")
	        {
	        	c12Y13 = "SP";
	        }
	        else if (estado=="Sinaloa")
	        {
	        	c12Y13 = "SL";
	        }
	        else if (estado=="Sonora")
	        {
	        	c12Y13 = "SR";
	        }
	        else if (estado=="Tabasco")
	        {
	        	c12Y13 = "TC";
	        }
	        else if (estado=="Tamaulipas")
	        {
	        	c12Y13 = "TS";
	        }
	        else if (estado=="Tlaxcala")
	        {
	        	c12Y13 = "TL";
	        }
	        else if (estado=="Veracruz")
	        {
	        	c12Y13 = "VZ";
	        }
	        else if (estado=="Yucatan")
	        {
	        	c12Y13 = "YN";
	        }
	        else if (estado=="Zacatecaz")
	        {
	        	c12Y13 = "ZS";
	        }
                     
            
            
            
			telefono();
			dia1(); mes1() ;años1();
			System.out.flush();

			JOptionPane.showMessageDialog(null,"\nTu edad es: "+ calcularEdad(dia1,mes1,años1)+"\nTu id es: "+ numero2()+
			"\nTu nombre: " + nombre + " " + apellidopaterno + " " + apellidomaterno+"\nTu Telefono es: "+ telefono_guiones+
			"\nTu curp: "+ c1Y2 + c1Y3 + c3 + c4 + c5Y6 + c5Y7+ c7Y8 +c9Y10 +c11+c12Y13+ c14+c15+c16+numero,null,-1);			
		}
	
		if("MUJER".equals(sexo))
		{
			estado = (JOptionPane.showInputDialog(null, "Elige tu estado: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Aguascalientes","Baja California","Baja California Sur","Campeche","Coahuila","Colima","Chiapas","Chihuahua","Durango","Distrito Federal","Guanajuato","Guerrero","Hidalgo","Jalisco","Estado de mexico","Michoacan","Morelos","Nayarit","Nuevo Leon","Oaxaca","Puebla","Queretaro","Quintana Roo","San Luis Potosil","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatan","Zacatecas"}, "Elige tu estado")).toString();
			
			años = (JOptionPane.showInputDialog(null, "Elige tu años: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"}, "Selecciona tu años")).toString();			
            
			mes = (JOptionPane.showInputDialog(null, "Elige tu mes: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12"}, "Selecciona tu mes")).toString();
			
			if("01".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();
			}
			
			if("02".equals(mes))
			{
				años1();	
				
				if( (años1==1972) || (años1==1976) || (años1==1980) || (años1==1984) || (años1==1988) || (años1==1992) || (años1==1996) || (años1==2000) || (años1==2004) || (años1==2008) || (años1==2012) || (años1==2016) || (años1==2020))
				{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"}, "Selecciona dia")).toString();	
				}
				
				else if( (años1==1970) || (años1==1971) || (años1==1973) || (años1==1974) || (años1==1975) || (años1==1977) || (años1==1978) || (años1==1979) || (años1==1981) || (años1==1982) || (años1==1983) || (años1==1985) || (años1==1986) || (años1==1987) || (años1==1989) || (años1==1990) || (años1==1991) || (años1==1993) || (años1==1994) || (años1==1995) || (años1==1997) || (años1==1998) || (años1==1999) || (años1==2001) || (años1==2002) || (años1==2003) || (años1==2005) || (años1==2006) || (años1==2007) || (años1==2009) || (años1==2010) || (años1==2011) || (años1==2013) || (años1==2014) || (años1==2015) || (años1==2017) || (años1==2018) || (años1==2019) || (años1==2021) || (años1==2022) || (años1==2023))
				{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"}, "Selecciona dia")).toString();	
				}
			}
				
			if("03".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("04".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("05".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("06".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("07".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("08".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				
			if("09".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("10".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();
			}
				
			if("11".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"}, "Selecciona dia")).toString();
			}
				
			if("12".equals(mes))
			{
				dia = (JOptionPane.showInputDialog(null, "Seleciona tu dia: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}, "Selecciona dia")).toString();	
			}
				                            
                                               
            String c1Y2 = apellidopaterno.substring(0,1);
            String c1Y3 = apellidopaterno.substring(1,2);
			char c3 = apellidomaterno.charAt(0);
			char c4 = nombre. charAt(0);
			String c5Y6 = años.substring(2,3);
			String c5Y7 = años.substring(3,4);//
			String c7Y8 = mes.substring(0);
	   		String c9Y10 = dia.substring(0);	        
	   		char c11 = sexo.charAt(0);
	        char c14 = apellidopaterno.charAt(2);
	        char c15 = apellidomaterno.charAt(2);
	        char c16 = nombre.charAt(2);
            String c12Y13 = "ho";
			
	    	if (estado=="Aguascalientes")
	    	{
	        	c12Y13 = "AS";
	        }
	        else if (estado=="Baja California")
	        {
	        	c12Y13 = "BC";
	        }
	        else if (estado=="Baja California Sur")
	        {
	        	c12Y13 = "BS";
	        }
	        else if (estado=="Campeche")
	        {
	        	c12Y13 = "CC";
	        }
	        else if (estado=="Coahuila")
	        {
	        	c12Y13 = "CL";
	        }
	        else if (estado=="Colima")
	        {
	        	c12Y13 = "CM";
	        }
	        else if (estado=="Chiapas")
	        {
	        	c12Y13 = "CS";
	        }
	        else if (estado=="Chiuahua")
	        {
	        	c12Y13 = "CH";
	        }
	        else if (estado=="Distrito Federal")
	        {
	        	c12Y13 = "DF";
	        }
	        else if (estado=="Durango")
	        {
	        	c12Y13 = "DG";
	        }
	        else if (estado=="Guanajuato")
	        {
	        	c12Y13 = "GT";
	        }
	        else if (estado=="Guerrero")
	        {
	        	c12Y13 = "GR";
	        }
	        else if (estado=="Hidalgo")
	        {
	        	c12Y13 = "HG";
	        }
	        else if (estado=="Jalisco")
	        {
	        	c12Y13 = "JC";
	        }
	        else if (estado=="Estado de mexico")
	        {
	        	c12Y13 = "MC";
	        }
	        else if (estado=="Michoacan")
	        {
	        	c12Y13 = "MN";
	        }
	        else if (estado=="Morelos")
	        {
	        	c12Y13 = "MS";
	        }
	        else if (estado=="Nayarit")
	        {
	        	c12Y13 = "NT";
	        }
	    	else if (estado=="Nuevo Leon")
	    	{
	        	c12Y13 = "NL";
	        }
	      	else if (estado=="Oaxaca")
	      	{
	        	c12Y13 = "OC";
	        }
	        else if (estado=="Puebla")
	        {
	        	c12Y13 = "PL";
	        }
	       	else if (estado=="Queretaro")
	       	{
	        	c12Y13 = "QT";
	        }
	        else if (estado=="Quintana Roo")
	        {
	        	c12Y13 = "QR";
	        }
	        else if (estado=="San Luis Potosil")
	        {
	        	c12Y13 = "SP";
	        }
	        else if (estado=="Sinaloa")
	        {
	        	c12Y13 = "SL";
	        }
	        else if (estado=="Sonora")
	        {
	        	c12Y13 = "SR";
	        }
	        else if (estado=="Tabasco")
	        {
	        	c12Y13 = "TC";
	        }
	        else if (estado=="Tamaulipas")
	        {
	        	c12Y13 = "TS";
	        }
	        else if (estado=="Tlaxcala")
	        {
	        	c12Y13 = "TL";
	        }
	        else if (estado=="Veracruz")
	        {
	        	c12Y13 = "VZ";
	        }
	        else if (estado=="Yucatan")
	        {
	        	c12Y13 = "YN";
	        }
	        else if (estado=="Zacatecaz")
	        {
	        	c12Y13 = "ZS";
	        }
      
            
            
            
			telefono();
			dia1(); mes1() ;años1();
			System.out.flush();


			JOptionPane.showMessageDialog(null,"\nTu edad es: "+ calcularEdad(dia1,mes1,años1)+"\nTu id es: "+ numero2()+
			"\nTu nombre: " + nombre + " " + apellidopaterno + " " + apellidomaterno+"\nTu Telefono es: "+ telefono_guiones+
			"\nTu curp: "+ c1Y2 + c1Y3 + c3 + c4 + c5Y6 + c5Y7+ c7Y8 +c9Y10 +c11+c12Y13+ c14+c15+c16+numero,null,-1);
		
		}opcion=Integer.parseInt(JOptionPane.showInputDialog(null,"Quieres volver a intentar= Si-1  No-2","Generador de curp",2));
		
		}while(opcion==1);
	}
	
	
	public static String nombre()
	{
		do
		{
		try
		{
		nombre = JOptionPane.showInputDialog(null, "Ingresar nombre","Generador de curp",3);
//
		if(nombre.matches("[ a-z A-Z Ã±Ã‘ Ã¡Ã©Ã­Ã³Ãº Ã�Ã‰Ã�Ã“Ãš]*"))

		{
			nombre=nombre.toUpperCase();
			a=true;
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"Ingrese Solamente Letras",null,0);
			a=false;
		}
		
		}catch (NullPointerException c)
		{
		a=true;
		}
		}while(a!=true);
        
		return nombre;
	}
	//
	public static String apellidopaterno()
	{
		do
		{
		try
		{
		apellidopaterno = JOptionPane.showInputDialog(null, "Ingresar apellido paterno","Generador de curp",3);
		
		if(apellidopaterno.matches("[ a-z A-Z Ã±Ã‘ Ã¡Ã©Ã­Ã³Ãº Ã�Ã‰Ã�Ã“Ãš]*"))
		{
			
				
				apellidopaterno=apellidopaterno.toUpperCase();
			a=true;
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"Ingrese Solamente Letras",null,0);
			a=false;
		}
		
		}catch (NullPointerException c)
		{
		a=true;
		}
		}while(a!=true);
		
		return apellidopaterno;
	}
	
	public static String apellidomaterno()
	{
		do
		{
		try
		{
		apellidomaterno = JOptionPane.showInputDialog(null, "Ingresar su apellido materno","Generador de curp",3);
		
		if(apellidomaterno
				.matches("[ a-z A-Z Ã±Ã‘ Ã¡Ã©Ã­Ã³Ãº Ã�Ã‰Ã�Ã“Ãš]*"))
		{
			apellidomaterno=apellidomaterno.toUpperCase();
			a=true;
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"Ingrese Solamente Letras",null,0);
			a=false;
		}
		
		}catch (NullPointerException c)
		{
		a=true;
		}
		}while(a!=true);
		
		return apellidomaterno;
	}
	
	public static int años1()
	{
	años1 = Integer.parseInt (años);
	
	return años1;
	}
	
	public static int años2()
	{
		años = (JOptionPane.showInputDialog(null, "SELECCIONA EL AÃ‘O: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"SELECCIONA","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"}, "Selecciona")).toString();
		años2= Integer.parseInt(años);
		return años2;
	}
	
	public static int mes2()
	{
		mes = (JOptionPane.showInputDialog(null, "SELECCIONA EL MES: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"SELECCIONA","ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"}, "Selecciona")).toString();
		mes2= Integer.parseInt(mes);
		return mes2;
	}

	public static int mes1()
	{
	mes1 = Integer.parseInt (mes);
	
	return mes1;
	}
	
	public static int dia1()
	{
	dia1 = Integer.parseInt (dia);
	
	return dia1;
	}
				
	//estado
	public static int estado2()
	{
		estado = (JOptionPane.showInputDialog(null, "SELECCIONA EL ESTADO: ", "Generador de curp", JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"SELECCIONA","AGUASCALIENTES","BAJA CALIFORNIA","BAJA CALIFORNIA SUR","CAMPECHE","COAHUILA","COLIMA","CHIAPAS","CHIHUAHUA","DURANGO","DISTRITO FEDERAL","GUANAJUATO","GUERRERO","HIDALGO","JALISCO","ESTADO DE MEXICO","MICHOACAN","MORELOS","NAYARIT","NUEVO LEON","OAXACA","PUEBLA","QUERETARO","QUINTANA ROO","SAN LUIS POTOSI","SINALOA","SONORA","TABASCO","TAMALUIPAS","TLAXCALA","VERACRUZ","YUCATAN","ZACATECAS"}, "Selecciona")).toString();
		estado2= Integer.parseInt(estado);		
		return estado2;
	}
	
	
	//telefono
	public static String telefono()
	{	
	do
	{	
	try
	{				
		
	telefono = JOptionPane.showInputDialog(null, "Ingresar su telefono","Generador de curp",3);
	if(telefono.length()==10 && telefono.matches("[0-9]*")){
	
	a=true;
	}
	else {
		JOptionPane.showMessageDialog(null,"Dato ingresado erroneo",null,0);
		a=false;
	}
	}
	catch(NumberFormatException c)
	{
		JOptionPane.showMessageDialog(null,"Ingrese Solamente Numeros",null,0);
		a=false;
	}
	}while(a!=true);	
	for(int i=0; i<telefono.length(); i++)
	{
		if((i%2==0) && (i !=0))
		{
			telefono_guiones += "-" + telefono.charAt(i); 
			continue;
		}
		telefono_guiones += telefono.charAt(i);			
	}	
	return telefono_guiones;
	}

		
	//generador de aleatorios
	public static int numero()
	{
	numero = (int)(Math.random()*100+1);
	
	return numero;
	}
	public static int numero2()
	{
	numero2 = (int)(Math.random()*100+1);
	
	return numero2;
	}

	
	public static int calcularEdad(int dia1, int mes1, int años1) 
	{
	LocalDate fechaHoy = LocalDate.now();
	LocalDate fechaNacimiento = LocalDate.of(años1, mes1, dia1);
 
	Period periodo = Period.between(fechaNacimiento, fechaHoy);
 
	return periodo.getYears();
	}

	
	
	
}