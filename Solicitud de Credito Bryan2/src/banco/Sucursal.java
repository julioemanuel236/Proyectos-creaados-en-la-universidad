package banco;
import java.io.*;

public class Sucursal {
	private Solicitud solicitudes[];
	private int csolicitud=0;
	private String datos="DATA.SOLICITUDES";
	
	public Sucursal() {
		if(!cargar())solicitudes = new Solicitud[10000];
	}
	
	public void nuevaSolicitud(Solicitud s) {
		if(s!=null)
			solicitudes[csolicitud++]=s;
		guardar();
	}
	
	public String personasConCapacidadDePagoSobre200() {
		String s="";
		
		for(int i=0;i<csolicitud;i++) {
			if(solicitudes[i] instanceof Personal) {
				Personal p = (Personal)solicitudes[i];
				
				if(p.capacidadDePago()>200)
					s+=p.getNombre()+' '+p.getCarnet()+'\n';
			}
			
		}
		
		return s;
	}
	
	public String listadoPersonasPuedenRecibir() {
		String s="";
		
		String arr[] = new String[10000];
		int size=0;
		
		for(int i=0;i<csolicitud;i++) {
			if(solicitudes[i] instanceof Personal) {
				if(solicitudes[i].puedeSolicitar()) {
					Personal p = (Personal)solicitudes[i];
					arr[size++]=p.getCarnet()+' '+p.getNombre();
				}
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if(arr[j+1]==null)break;
				if(arr[j+1].compareToIgnoreCase(arr[j])==-1) {
					String tmp1 = new String(arr[j]);
					String tmp2 = new String(arr[j+1]);
					arr[j] = tmp2;
					arr[j+1] = tmp1;
				}
			}
		}
		
		for(int i=0;i<size;i++)
			s+=arr[i]+'\n';
		
		return s;
	}

	public String listadoEmpresasPuedenRecibir() {
		String s="";
		
		String arr[] = new String[10000];
		int size=0;
		
		for(int i=0;i<csolicitud;i++) {
			if(solicitudes[i] instanceof Empresarial) {
				if(solicitudes[i].puedeSolicitar()) {
					Empresarial p = (Empresarial)solicitudes[i];
					arr[size++]=p.getMinisterio()+' '+p.getCodigo()+' '+p.getNombre();
				}
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=i;j<size;j++) {
				if(arr[j+1]==null)break;
				if(arr[j+1].compareToIgnoreCase(arr[j])==-1) {
					String tmp1 = new String(arr[j]);
					String tmp2 = new String(arr[j+1]);
					arr[j] = tmp2;
					arr[j+1] = tmp1;
				}
			}
		}
		
		for(int i=0;i<size;i++)
			s+=arr[i]+'\n';
		
		return s;
	}

	public float dineroTotalCredito() {
		float f=0;
		
		for(int i=0;i<csolicitud;i++)
			if(solicitudes[i].puedeSolicitar())f+=solicitudes[i].getCredito();
		
		return f;
	}

	public String tiempoPagarPersonales() {
		String s="";
		
		for(int i=0;i<csolicitud;i++) {
			if(solicitudes[i].puedeSolicitar()) 
				if(solicitudes[i] instanceof Personal) {
					Personal p = (Personal)solicitudes[i];
					s+=p.getCarnet()+'\t'+p.mesesEnPagar()+" Meses \n";
			
			}
		}
		
		return s;
	}

	public String tiempoPagarEmpresariales() {
		String s="";
		
		for(int i=0;i<csolicitud;i++) {
			if(solicitudes[i].puedeSolicitar()) 
				if(solicitudes[i] instanceof Empresarial) {
					Empresarial p = (Empresarial)solicitudes[i];
					s+=p.getNombre()+'\t'+p.mesesEnPagar()+" Meses\n";
			
			}
		}
		
		return s;
	}

	public boolean guardar() {
		try {
			FileOutputStream fos = new FileOutputStream(datos);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(solicitudes);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean cargar() {
		try {
			FileInputStream fis = new FileInputStream(datos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			solicitudes = (Solicitud[]) ois.readObject();

			for(int i=0;solicitudes[i]!=null;i++)
				csolicitud++;
			System.out.println(csolicitud);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
