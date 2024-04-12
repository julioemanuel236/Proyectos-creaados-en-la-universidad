public class PersonajeGenerico {
    private int vida;
    private int movimiento;
    private int daño;
    private int porcentajeAcierto;
    private String nombre;
    private String color;
    private int costo;

    private boolean vuela;

    private String tipoAtaque="cruz";

    private int posX=0;
    private int posY=0;

    public PersonajeGenerico(int vida, int movimiento, int daño, int porcentajeAcierto, String nombre, String color, int costo, boolean vuela) {
        this.vida = vida;
        this.movimiento = movimiento;
        this.daño = daño;
        this.porcentajeAcierto = porcentajeAcierto;
        this.nombre = nombre;
        this.color = color;
        this.costo = costo;
        this.vuela = vuela;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getPorcentajeAcierto() {
        return porcentajeAcierto;
    }

    public void setPorcentajeAcierto(int porcentajeAcierto) {
        this.porcentajeAcierto = porcentajeAcierto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public boolean getVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }

    public void setTipoAtaque(String tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    public String getTipoAtaque(){
        return tipoAtaque;
    }

    protected char getInicial() {
        return nombre.charAt(0);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


    public void setPosicion(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}