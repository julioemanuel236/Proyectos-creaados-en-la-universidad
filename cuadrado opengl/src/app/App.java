package app;
import net.letskit.redbook.glskeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;
import com.sun.opengl.util.*;

import javax.media.opengl.GLEventListener;

/**
 * This is a simple double buffered program. Pressing the left mouse button
 * rotates the rectangle. Pressing the middle mouse button stops the rotation.
 *
 * @author Kiet Le (Java conversion)
 */
public class Doublebuf1//
        extends glskeleton//
        implements //
        GLEventListener//
        , KeyListener//
        , MouseListener//
{
    private float spin = 0f, spinDelta = 0f;
    
    public Doublebuf1() {
    }
    
    public static void main(String[] args) {
        //
        GLCapabilities caps = new GLCapabilities();
        caps.setDoubleBuffered(true);// request double buffer display mode
        GLJPanel canvas = new GLJPanel(caps);
        Doublebuf1 demo = new Doublebuf1();
        demo.setCanvas(canvas);
        canvas.addGLEventListener(demo);
        demo.setDefaultListeners(demo);
        
        demo.setDefaultAnimator(24);
        //
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Doublebuf1");
        frame.setSize(512, 256);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.requestFocusInWindow();
        demo.animate();
    }
    
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        //
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_FLAT);
    }
    
    public synchronized void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        //
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPushMatrix();
        gl.glRotatef(spin, 0.0f, 0.0f, 1.0f);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glRectf(-25.0f, -25.0f, 25.0f, 25.0f);
        gl.glPopMatrix();
        
        gl.glFlush();
        
        spinDisplay();
    }
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL gl = drawable.getGL();
        
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        float aspect = 0;
        if (w <= h) {
            aspect = (float) h / (float) w;
            gl.glOrtho(-50.0, 50.0, -50.0 * aspect, 50.0 * aspect, //
                    -1.0, 1.0);
        } else {
            aspect = (float) w / (float) h;
            gl.glOrtho(-50.0 * aspect, 50.0 * aspect, -50.0, 50.0, //
                    -1.0, 1.0);
        }
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged) {
    }
    
    private void spinDisplay() {
        spin = spin + spinDelta;
        if (spin > 360f)
            spin = spin - 360;
    }
    
    public void keyTyped(KeyEvent key) {
    }
    
    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                super.runExit();
            default:
                break;
        }
    }
    
    public void keyReleased(KeyEvent key) {
    }
    
    public void mouseClicked(MouseEvent key) {
    }
    
    public void mousePressed(MouseEvent mouse) {
        switch (mouse.getButton()) {
            case MouseEvent.BUTTON1:
                spinDelta = 2f;
                break;
            case MouseEvent.BUTTON2:
            case MouseEvent.BUTTON3:
                spinDelta = 0f;
                break;
        }//
        
        super.refresh();
    }
    
    public void mouseReleased(MouseEvent mouse) {
    }
    
    public void mouseEntered(MouseEvent mouse) {
    }
    
    public void mouseExited(MouseEvent mouse) {
    }
    
}//
