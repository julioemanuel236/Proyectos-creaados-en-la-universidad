package com.nobody.adMEnestrator;

public class ClasesProyecto{

	public class Medio{
		String nombre;
		String codigo;

		public Medio(String n,String c){
			this.nombre=n;
			this.codigo=c;
		}

	}

	public class Becado{
		String solapin;
		String ID;
		String nombre;
		String apellidos;
		String sexo;
		String provincia;
		String apartamento;
		String correo;
		int	   fechaIngreso;
		Medio[] avituallamiento = new Medio[15];
		int  [] cmedios = new int[15];
	} 

	public class Estudiante extends Becado{
		int facultad;
		int anio;
		String observacion;
		char evaluacion;

		private void init_avituallamiento(){
			avituallamiento[0]=new Medio("sabana","000015");
			avituallamiento[1]=new Medio("sobrecama","000015");
			avituallamiento[2]=new Medio("toalla","000015");
			avituallamiento[3]=new Medio("colcha","000015");
			avituallamiento[4]=new Medio("percha","000015");
			avituallamiento[5]=new Medio("sweater","000015");
			cmedios[0]=2;
			cmedios[1]=1;
			cmedios[2]=1;
			cmedios[3]=1;
			cmedios[4]=5;
			cmedios[5]=1;
		}
	}

	public class BecadoInterno extends Becado{
		private void init_avituallamiento(){
			avituallamiento[0]=new Medio("sabana","000015");
			avituallamiento[1]=new Medio("sobrecama","000015");
			avituallamiento[2]=new Medio("toalla","000015");
			avituallamiento[3]=new Medio("colcha","000015");
			avituallamiento[4]=new Medio("percha","000015");
			cmedios[0]=4;
			cmedios[1]=1;
			cmedios[2]=2;
			cmedios[3]=1;
			cmedios[4]=6;
		}
	}

	public class Profesor extends BecadoInterno{
		String apartamento;
		int Facultad;
		String asignatura;
		String categoriaDocente;
		String categoriaCientifica;

	}

	public class TrabajadorResidencia extends BecadoInterno{
		String labor;
	}

	public class JefeResidencia extends TrabajadorResidencia{
		String correo;
		String numeroOficina;
	}

	public class Interno extends BecadoInterno{
		String empresa;
		String motivoResidencia;
		String trabajo;

	}

	public class Apartamento{
		int tipo;
		String numero;
		int capcaidad_maxima;
		int cantidad_real;
		Medio[] medios = new Medio[15];
		int   [] cmedios = new int[15];
		String motivoDesabilitado;
		Estudiante[] estudiantes;
		boolean limpiezaApat;
		boolean limpiezaMB;
		boolean cumplimientoGuardia;
		boolean limpiezaExteriores;

		private void init_medios(){
			medios[0]=new Medio("televisor","000000");
			medios[1]=new Medio("copmutadora","000001");
			medios[2]=new Medio("telefono","000002");
			medios[3]=new Medio("espejo","000003");
			medios[4]=new Medio("mesa","000004");
			medios[5]=new Medio("silla","000005");
			medios[6]=new Medio("tubo lampara fluorecente","000006");
			cmedios[0]= 1;
			cmedios[1]= 1;
			cmedios[2]= 1;
			cmedios[3]= 1;
			cmedios[4]= 1;
			cmedios[5]= 4;
			cmedios[6]= 20;
			if(tipo==1)init_estudiantes();
			else{
				init_otros();
			}
		}

		private void init_otros(){
			medios[7]=new Medio("video","000007");
			medios[8]=new Medio("cocina gas","000008");
			medios[9]=new Medio("sillon","000009");
			medios[10]=new Medio("sofa","000010");
			medios[11]=new Medio("armario","000011");
			medios[12]=new Medio("cama personal","000012");
			medios[13]=new Medio("gavetero","000013");
			medios[14]=new Medio("aire acondicionado","000014");
			medios[15]=new Medio("refrigerador","000015");
			cmedios[7]=1;
			cmedios[8]=1;
			cmedios[9]=2;
			cmedios[10]=1;
			cmedios[11]=3;
			cmedios[12]=6;
			cmedios[13]=1;
			cmedios[14]=3;
			cmedios[15]=1;
		}

		private void init_estudiantes(){
			medios[7]=new Medio("nevera","000007");
			medios[8]=new Medio("sillon","000008");
			medios[9]=new Medio("closet","000009");
			medios[10]=new Medio("literas","000010");
			medios[11]=new Medio("mesa cuarto","000011");
			medios[12]=new Medio("silla cuarto","000012");
			cmedios[7]= 1;
			cmedios[8]= 3;
			cmedios[9]= 6;
			cmedios[10]= 6;
			cmedios[11]= 3;
			cmedios[12]= 3;
			if(getCategoria()==5&&estudiantesB()){
				medios[13]=new Medio("caja temperatura agua","000013");
				cmedios[13]= 1;
			}
		}

		private int getCategoria(){
			if(tipo==1){
				int c=(limpiezaMB?1:0)+
					  (limpiezaApat?1:0)+
					  (cumplimientoGuardia?1:0);
				return 2+c;
			}
			else{
				int c=(limpiezaMB?1:0)+
					  (limpiezaApat?1:0)+
					  (limpiezaExteriores?1:0);
				return 2+c;	
			}
		}

		private boolean estudiantesB(){
			for(Estudiante i :estudiantes)
				if(i.evaluacion!='B')return false;
			return true;
		}

	}

	private class Edificio{
		String numero;
		String nombre;
		Apartamento[] apartamentos;	

	}

	public class SubDireccion{
		String nombre;
		String ubicacion;
		Medio[] medios;
		int  [] cmedios;
	}
}