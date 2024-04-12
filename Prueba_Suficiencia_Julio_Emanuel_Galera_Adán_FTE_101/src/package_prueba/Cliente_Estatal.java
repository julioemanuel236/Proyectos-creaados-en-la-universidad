package package_prueba;

public class Cliente_Estatal extends Cliente{
	boolean arrendada;
	
	public Cliente_Estatal(String n,String c,String d,String t,boolean can,boolean a) {
		super(n,c,d,t,can);
		arrendada=a;
	}
	
	float pago() {
		float pago=0;
		for(Llamada_Internacional i :this.llamadasInter) {
			pago += i.minutos*(i.tarifa+0.5);
		}
		
		for(Llamada_Interprovincial i :this.llamadasProvi) {
			pago += i.minutos*
					Math.abs(
					Integer.parseInt(i.formatear(i.saliente)[2])-
					Integer.parseInt(i.formatear(i.entrante)[2])
					);
		}
		int min = 0;
		for(Llamada i :this.llamadas) {
			 min += i.minutos;
		}
		return pago+(min>300?(min-300)*0.05f:0);
	}
}
