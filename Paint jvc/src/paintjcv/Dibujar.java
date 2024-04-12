/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintjcv;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Juan Carlos Valencia
 */
public class Dibujar extends Canvas implements MouseListener, MouseMotionListener {

    public ArrayList<AtributosFormas> shapes;
    AtributosFormas forma;
    private boolean start;
    public Color color;
    public int strk_whith;
    public int opcion;

    Dibujar() {
        this.color = Color.BLACK;
        this.setBackground(Color.white);
        this.strk_whith = 10;
        this.opcion = 2;
        this.start = false;
        this.shapes = new ArrayList<>();
    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(Color.white);
        draw.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (int i = 0; i < this.shapes.size(); i++) {

            draw.setStroke(new BasicStroke(this.shapes.get(i).getGrosor()));
            draw.setColor(this.shapes.get(i).getColor());

            switch (this.shapes.get(i).getTipo()) {
                case 1:
                    draw.drawLine(this.shapes.get(i).getX(), this.shapes.get(i).getY(), this.shapes.get(i).getX1(), this.shapes.get(i).getY1());
                    break;
                case 2:
                    draw.drawLine(this.shapes.get(i).getX(), this.shapes.get(i).getY(), this.shapes.get(i).getX1(), this.shapes.get(i).getY1());
                    break;
                case 3:
                    draw.drawLine(this.shapes.get(i).getX(), this.shapes.get(i).getY(), this.shapes.get(i).getX1(), this.shapes.get(i).getY1());
                    break;
                case 4:
                    draw.drawRect(this.shapes.get(i).getX(), this.shapes.get(i).getY(), this.shapes.get(i).getX1(), this.shapes.get(i).getY1());
                    break;
                case 5:
                    draw.drawOval(this.shapes.get(i).getX(), this.shapes.get(i).getY(), this.shapes.get(i).getX1(), this.shapes.get(i).getY1());
                    break;
            }
        }
        
        draw.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {

        if (me.getButton() == MouseEvent.BUTTON1) {
            this.start = true;
            this.forma = new AtributosFormas(me.getX(), me.getY(), strk_whith, opcion, color);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            if (this.start) {
                this.start = false;

                if (this.opcion == 4 || this.opcion == 5) {

                    if (this.forma.getX() < me.getX()) {
                        this.forma.setX1(me.getX() - this.forma.getX());
                        
                    } else if (this.forma.getX() > me.getX()) {
                        this.forma.setX1(this.forma.getX() - me.getX());
                        this.forma.setX(me.getX());
                    }

                    if (this.forma.getY() < me.getY()) {
                        this.forma.setY1(me.getY() - this.forma.getY());
                        
                    } else if (this.forma.getY() > me.getY()) {
                        this.forma.setY1(this.forma.getY() - me.getY());
                        this.forma.setY(me.getY());
                    }

                    if (this.forma.getY() > 0 && this.forma.getX() > 0) {
                        this.shapes.add(this.forma);
                        repaint();
                    }

                } else {
                    this.forma.setX1(me.getX());
                    this.forma.setY1(me.getY());

                    this.shapes.add(this.forma);
                    repaint();
                }

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {

        if (!me.isMetaDown()) {

            if (opcion == 1 || opcion == 2) {
                if (this.start) {
                    this.start = false;
                    this.forma = new AtributosFormas(me.getX(), me.getY(), strk_whith, opcion, color);
                } else {
                    this.start = true;
                    this.forma.setX1(me.getX());
                    this.forma.setY1(me.getY());

                    this.shapes.add(this.forma);
                }

                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}