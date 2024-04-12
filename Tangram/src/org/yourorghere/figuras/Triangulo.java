/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere.figuras;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class Triangulo extends Figura{
                
    public Triangulo(){        
        super();
        setPolygon(initVertices());  
        setRadio(1);
    }
    
    public ArrayList<Point> initVertices() {
        ArrayList<Point> temp = new ArrayList<Point>();
        temp.add(new Point(0,  (float)(Math.sqrt(3) / 3f )));   // V�rtice superior
        temp.add(new Point(-1 / 2f, - (float)(Math.sqrt(3) / 6f )));  // V�rtice inferior izquierdo
        temp.add(new Point(1 / 2f, - (float)(Math.sqrt(3) / 6f )));   // V�rtice inferior derecho
        return temp;
    }
    
    public void draw(GL gl) {
                       
        gl.glPushMatrix(); // Guardar la matriz actual
// Dibujar el objeto aqu�

        gl.glTranslatef(getX(), getY(), getZ());
        gl.glRotatef(getRotacion(), 0, 0, 1);
        gl.glBegin(GL.GL_TRIANGLES);
        Point p;
        gl.glColor3f(1.0f, 0.0f, 0.0f);    // Rojo
        p = getPolygon().get(0);
        gl.glVertex2f(p.x * getRadio(), p.y * getRadio());   // V�rtice superior
        gl.glColor3f(0.0f, 0.5f, 0.0f);    // Verde
        p = getPolygon().get(1);
        gl.glVertex2f(p.x * getRadio(), p.y * getRadio());   // V�rtice superior
        gl.glColor3f(0.0f, 0.0f, 1.0f);    // Azul
        p = getPolygon().get(2);
        gl.glVertex2f(p.x * getRadio(), p.y * getRadio());   // V�rtice superior
        gl.glEnd();        
        //gl.glTranslatef(-getX(), -getY(), -getZ());
        gl.glPopMatrix(); // Restaurar la matriz original
        
        setRotacion(getRotacion()+1);
    }

}
