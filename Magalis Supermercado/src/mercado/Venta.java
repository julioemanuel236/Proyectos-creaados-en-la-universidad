package mercado;

public class Venta {
	Producto producto;
	int      cantidad;
	
	public Venta(Producto p,int c) {
		producto=p;
		cantidad=c;
	}
	
	public String datos() {
		return producto.getNombre()+" "+cantidad;
	}
}
