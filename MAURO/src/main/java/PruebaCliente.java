public class PruebaCliente {
    public static void main(String[] args) {
        // Crear un nuevo cliente
        Cliente cliente = new Cliente("Juan Perez", "1234567890");
        // Agregar productos al cliente
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        producto1.setNombre("Producto 1");
        producto2.setNombre("Producto 2");
        cliente.agregarProducto(producto1);


        // Mostrar la información del cliente y sus productos
        System.out.println(" ////Información del cliente: ////");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Cédula: " + cliente.getCedula());
        for (Producto producto : cliente.getProductos()) {
            System.out.println("Nombre del producto: " + producto.getNombre());
        }

        // Calcular el dinero total gastado por el cliente
        int dineroTotal = cliente.dineroTotal();
        System.out.println("Dinero total gastado: " + dineroTotal);
    }
}

//aqui se realiza la prueba de la clase cliente



    /*public static void main(String[] args) {

        Cliente cliente = new Cliente("juan", "1234567890");
        Cliente cliente1 = new Cliente("pedro", "0987654321");
        Cliente cliente2 = new Cliente("maria", "1234567890");


        cliente.setCedula("1234567890");
        cliente.setNombre("juan");
        cliente1.setCedula("0987654321");
        cliente.getCedula();
        cliente.getNombre();


        System.out.println(cliente);
        System.out.println(cliente1);
    }

     */


