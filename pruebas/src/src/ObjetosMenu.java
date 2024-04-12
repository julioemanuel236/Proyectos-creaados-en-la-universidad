public class ObjetosMenu {
    private SemillaDeLaVida semillaDeLaVida;
    private ElixirVerde elixirVerde;
    private CapaDeMovilidad capaDeMovilidad;

    public ObjetosMenu(){
        this.semillaDeLaVida = new SemillaDeLaVida();
        this.elixirVerde = new ElixirVerde();
        this.capaDeMovilidad = new CapaDeMovilidad();
    }

    public void obtenerOpciones() {
        System.out.println("1. Semilla de la vida");
        System.out.println("2. Elixir verde");
        System.out.println("3. Capa de movilidad");
    }

    public SemillaDeLaVida getSemillaDeLaVida() {
        return semillaDeLaVida;
    }

    public ElixirVerde getElixirVerde() {
        return elixirVerde;
    }

    public CapaDeMovilidad getCapaDeMovilidad() {
        return capaDeMovilidad;
    }
}

