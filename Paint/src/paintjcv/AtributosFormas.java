package paintjcv;

import java.awt.Color;

public final class AtributosFormas {

    private int x;
    private int y;
    private int x1;
    private int y1;
    private int grosor;
    private int tipo;
    private Color color;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the grosor
     */
    public int getGrosor() {
        return grosor;
    }

    /**
     * @param grosor the grosor to set
     */
    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public AtributosFormas() {
    }

    public AtributosFormas(int x, int y, int grosor, int tipo, Color color) {

        setX(x);
        setY(y);
        setGrosor(grosor);
        setTipo(tipo);
        setColor(color);
        setTipo(tipo);
        setX1(0);
        setY1(0);

    }

    public AtributosFormas(int x, int y, int x1, int y1, int grosor, int tipo, Color color) {

        setX(x);
        setY(y);
        setGrosor(grosor);
        setTipo(tipo);
        setColor(color);
        setTipo(tipo);
        setX1(x1);
        setY1(y1);
    }
}
