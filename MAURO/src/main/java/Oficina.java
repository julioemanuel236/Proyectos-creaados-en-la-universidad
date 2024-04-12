import java.util.ArrayList;

public class Oficina {
    private ArrayList<Cliente> clientes;

    public Oficina() {
        clientes = new ArrayList<Cliente>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }


    public String toString() {
        return "Clientes: " + clientes;
    }





}