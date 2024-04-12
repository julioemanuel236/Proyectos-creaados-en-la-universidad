package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import org.yourorghere.figuras.*;
        


/**
 * Tangram.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */

public class Tangram implements GLEventListener,MouseListener, MouseMotionListener  {

    private static int lastX, lastY;
    private static GL gl;
    private static GLU glu;
            
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");        
        GLCanvas canvas = new GLCanvas();        
        canvas.addMouseListener(new Tangram());
        canvas.addMouseMotionListener(new Tangram());
        canvas.addGLEventListener(new Tangram());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    Triangulo t1 = new Triangulo();
    Triangulo t2 = new Triangulo();
    
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
                
        gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        GLCanvas canvas = new GLCanvas();       

 
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl = drawable.getGL();
        glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        //gl.glTranslatef(-1.5f, 0.0f, -3.0f);
        
        t1.draw(gl);
        t2.setX(1);
        t2.draw(gl);
     /* // Drawing Using Triangles
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1.0f, 0.0f, 0.0f);    // Set the current drawing color to red
            gl.glVertex3f(0.0f, 1.0f, 0.0f);   // Top
            gl.glColor3f(0.0f, 1.0f, 0.0f);    // Set the current drawing color to green
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
            gl.glColor3f(0.0f, 0.0f, 1.0f);    // Set the current drawing color to blue
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
        // Finished Drawing The Triangle
        gl.glEnd();*/

        // Move the "drawing cursor" to another position        
        // Draw A Quad
        /*gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.5f, 1.0f);    // Set the current drawing color to light blue
            gl.glVertex3f(-1.0f, 1.0f, 0.0f);  // Top Left
            gl.glVertex3f(1.0f, 1.0f, 0.0f);   // Top Right
            gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom Right
            gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
        // Done Drawing The Quad
        gl.glEnd();*/
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void mouseClicked(MouseEvent e) {
      
    }

        @Override
    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
            System.out.println(lastX+ " "+lastY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - lastX;
        int dy = e.getY() - lastY;
        //t.mover(dx, dy);
        //t.mover(dx, dy);
        lastX = e.getX();
        lastY = e.getY();
    }
    

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override    
    public void mouseMoved(MouseEvent e) {
        System.out.println("MOVIENDO");
        int x = e.getX();
        int y = e.getY();
        IntBuffer viewport = IntBuffer.allocate(16);
        DoubleBuffer modelview = DoubleBuffer.allocate(16);
        DoubleBuffer projection = DoubleBuffer.allocate(16);
        FloatBuffer winPos = FloatBuffer.allocate(3);

        gl.glGetIntegerv(GL.GL_VIEWPORT, viewport);
        gl.glGetDoublev(GL.GL_MODELVIEW_MATRIX, modelview);
        gl.glGetDoublev(GL.GL_PROJECTION_MATRIX, projection);

        // Obtener la posición del mouse en coordenadas de OpenGL
        float winX = (float) x;
        float winY = (float) viewport.get(3) - (float) y;
        gl.glReadPixels((int) winX, (int) winY, 1, 1, GL.GL_DEPTH_COMPONENT, GL.GL_FLOAT, winPos);

        // Convertir las coordenadas a coordenadas de espacio 3D
        DoubleBuffer position = DoubleBuffer.allocate(3);
        glu.gluUnProject(winX, winY, winPos.get(0), modelview, projection, viewport, position);
        System.out.println("Projection Matrix:");
        printMatrix(projection);
        System.out.println("Modelview Matrix:");
        printMatrix(modelview);
        System.out.println("Position:");
        System.out.println("x: " + position.get(0) + ", y: " + position.get(1) + ", z: " + position.get(2));

        // Verificar si el punto está dentro de alguna figura
        /*Point mousePoint = new Point((int) position[0], (int) position[1]);
        for (Figura figura : figuras) {
            if (figura.contienePunto(mousePoint)) {
                // El puntero está sobre esta figura
                // Hacer algo...
                break; // No es necesario seguir buscando
            }
        }*/
    }
    private void printMatrix(DoubleBuffer matrix) {
        for (int i = 0; i < 4; i++) {
            System.out.println(matrix.get(i) + ", " + matrix.get(i + 4) + ", " + matrix.get(i + 8) + ", " + matrix.get(i + 12));
    }
    
}



}