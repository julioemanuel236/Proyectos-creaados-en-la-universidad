/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CuboRotando {
   
    static CuboRotando cube;
    
    private float xInitRotAngle = 0f;
    private float yInitRotAngle = 0f;
    private float zInitRotAngle = 0f;
    private float orbAngle = 0;

    private float x = .5f;
    private float y = .5f;
    private float z = .5f;
    private float xRotAngle;
    private float yRotAngle;
    private float zRotAngle;
    
    
    static public boolean rotate = true;
    public CuboRotando(float x, float xRotAngle, float yRotAngle, float zRotAngle){
        //this.x = x;
        this.xRotAngle = xRotAngle;
        this.yRotAngle = yRotAngle;
        this.zRotAngle = zRotAngle;
        
    }

    public void display(GLAutoDrawable drawable) {
        update();
        render(drawable);
    }

    public void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_FASTEST);

        // Handle depth
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);

        
        cube.draw(drawable);
        
    }
    
    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Replace current matrix with the identity matrix
        gl.glLoadIdentity();

        // Push current matrix onto a stack
        gl.glPushMatrix();

        // Handle position by translating

        // Handle cube's rotation in the plane {z = 0} around the origin at a distance of distRotCenter from the cube

        // Handle cube's rotation around its own axis
        // Define a rotation through angle xRotAngle about an axis direction (1, 0, 0) (i.e.: x axis)
        gl.glRotatef(this.xInitRotAngle, 1, 0, 0);
        // Define a rotation through angle xRotAngle about an axis direction (0, 1, 0) (i.e.: y axis)
        gl.glRotatef(this.yInitRotAngle, 0, 1, 0);
        // Define a rotation through angle xRotAngle about an axis direction (0, 0, 1) (i.e.: z axis)
        gl.glRotatef(this.zInitRotAngle, 0, 0, 1);

        // Start quadrilateral drawing
        gl.glBegin(GL2.GL_TRIANGLES);

        // FRONT RIGHT UP
        gl.glColor3f(0, 0, 1); // Red
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(this.x, 0,0);
        gl.glVertex3f(0, this.y, 0);

        // FRONT RIGHT DOWN
        gl.glColor3f(0, 1, 0); // Green
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(this.x, 0,0);
        gl.glVertex3f(0, -this.y, 0);
                
        //FRONT LEFT UP
        gl.glColor3f(0, 1, 1); // Yellow        
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(-this.x, 0,0);
        gl.glVertex3f(0, this.y, 0);
        
        // FRONT LEFT DOWN
        gl.glColor3f(1, 0 , 0); // Blue
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(-this.x, 0,0);
        gl.glVertex3f(0, -this.y, 0);
        
        // BOTTOM RIGHT UP 
        gl.glColor3f(1, 0, 1); // Yellow
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(this.x, 0,0);
        gl.glVertex3f(0, this.y, 0);
        
        // BOTTOM RIGHT DOWN
        gl.glColor3f(1, 1, 1); // Orange
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(this.x, 0,0);
        gl.glVertex3f(0, -this.y, 0);
        
        // BOTTOM LEFT UP
        gl.glColor3f( 0, 0,0.5f ); // White
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(-this.x, 0,0);
        gl.glVertex3f(0, this.y, 0);
        
        
        //BOTTOM LEFT DOWN
        gl.glColor3f(0, 0.5f, 0);
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(-this.x, 0,0);
        gl.glVertex3f(0, -this.y, 0);
        // Stop quadrilateral drawing
        gl.glEnd();

        // Pull the top matrix off the stack
        gl.glPopMatrix();
    }

    public void update() {
        if(rotate){
            this.xInitRotAngle += this.xRotAngle;
            this.yInitRotAngle += this.yRotAngle;
            this.zInitRotAngle += this.zRotAngle;
        }
    }
 
        public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(capabilities);

        Frame frame = new Frame("Rotating cubes");
        frame.setSize(700, 700);
        frame.add(canvas);
        frame.setVisible(true);        
        // Draw the cubes
        cube = new CuboRotando(.1f, 1, 0, 1);
        
        canvas.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent me) {
                
            }

            public void mousePressed(MouseEvent me) {
                if(me.getButton() == MouseEvent.BUTTON3) {
                    rotate = true;
                    System.out.println("Bot�n derecho presionado");
                } else if(me.getButton() == MouseEvent.BUTTON1) {
                    rotate = false;
                    System.out.println("Bot�n izquierdo presionado");
                }
            }


            public void mouseReleased(MouseEvent me) {
                
            }

            public void mouseEntered(MouseEvent me) {
                
            }

            public void mouseExited(MouseEvent me) {
                
            }
        
        });
        canvas.addGLEventListener(new GLEventListener() {
            @Override
                public void display(GLAutoDrawable drawable) {
                    update();
                    render(drawable);
                }

                @Override
                public void dispose(GLAutoDrawable drawable) {
                }

                @Override
                public void init(GLAutoDrawable drawable) {
                }

                public void render(GLAutoDrawable drawable) {
                    GL2 gl = drawable.getGL().getGL2();

                    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
                    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_FASTEST);

                    // Handle depth
                    gl.glEnable(GL2.GL_DEPTH_TEST);
                    gl.glDepthFunc(GL2.GL_LEQUAL);

                    cube.draw(drawable);

                }
                
                public void update() {
                    cube.update();
                }

                @Override
                public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
                }
        });

        final FPSAnimator animator = new FPSAnimator(canvas, 60);
        
        // Start the animation
        animator.start();

        // Terminate the program when the window is asked to close
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
