import javax.media.opengl.*;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;


public class Arroyo_21031101{
    
    static int mousex = 0;
    static int mousey = 0;
    
    static boolean clicked = false;
    static int xdir = 0;
    static int ydir = 0;
    
    public static class Octaedro{
        
    private float xInitRotAngle = 0f;
    private float yInitRotAngle = 0f;
    private float zInitRotAngle = 0f;    
    
    private float x = 0;
    private float y = 0;
    private float z = 0;
    private float xRotAngle = 0;
    private float yRotAngle = 0;
    private float zRotAngle = 0;
    private float posx = 0,posy = 0,posz = 0;
    private float angle = 0;
    
    public Octaedro(float size,float x, float y, float z, float xRotAngle, float yRotAngle, float zRotAngle) {
        
        this.x = size;
        this.y = size;
        this.z = size;
        this.posx = x;
        this.posy = y;
        this.posz = z;
        this.xRotAngle = xRotAngle;
        this.yRotAngle = yRotAngle;
        this.zRotAngle = zRotAngle;                        
    
    }
    
    public void draw(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        gl.glLoadIdentity();

        gl.glPushMatrix();
        
        //orbitar
        gl.glRotatef(this.xInitRotAngle, 1, 0, 0);        
        gl.glRotatef(this.yInitRotAngle, 0, 1, 0);        
        gl.glRotatef(this.zInitRotAngle, 0, 0, 1);        
        gl.glTranslatef(this.posx, this.posy, this.posz);
        
        //girar sobre mi eje
        //gl.glRotatef(this.xInitRotAngle, 1, 0, 0);        
        gl.glRotatef(angle, 0, 1, 0);                
        //gl.glRotatef(this.zInitRotAngle, 0, 0, 1);       
        angle+=10f;
        
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glScalef(this.x, this.y, this.z);
        // FRONT RIGHT UP
        gl.glColor3f(0, 0, 1); // Red
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(this.x, 0, 0);
        gl.glVertex3f(0, this.y, 0);

        // FRONT RIGHT DOWN
        gl.glColor3f(0, 1, 0); // Green
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(this.x, 0, 0);
        gl.glVertex3f(0, -this.y, 0);

        //FRONT LEFT UP
        gl.glColor3f(0, 1, 1); // Yellow        
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(-this.x, 0, 0);
        gl.glVertex3f(0, this.y, 0);

        // FRONT LEFT DOWN
        gl.glColor3f(1, 0, 0); // Blue
        gl.glVertex3f(0, 0, this.z);
        gl.glVertex3f(-this.x, 0, 0);
        gl.glVertex3f(0, -this.y, 0);

        // BOTTOM RIGHT UP 
        gl.glColor3f(1, 0, 1); // Yellow
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(this.x, 0, 0);
        gl.glVertex3f(0, this.y, 0);

        // BOTTOM RIGHT DOWN
        gl.glColor3f(1, 1, 1); // Orange
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(this.x, 0, 0);
        gl.glVertex3f(0, -this.y, 0);

        // BOTTOM LEFT UP
        gl.glColor3f(0, 0, 0.5f); // White
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(-this.x, 0, 0);
        gl.glVertex3f(0, this.y, 0);

        //BOTTOM LEFT DOWN
        gl.glColor3f(0, 0.5f, 0);
        gl.glVertex3f(0, 0, -this.z);
        gl.glVertex3f(-this.x, 0, 0);
        gl.glVertex3f(0, -this.y, 0);
        // Stop quadrilateral drawing
        gl.glEnd();

        // Pull the top matrix off the stack
        gl.glPopMatrix();
    }

    public void update() {
        this.xInitRotAngle+=xdir;
        this.yInitRotAngle+=ydir;
        this.zInitRotAngle+=zRotAngle;            
    }
    
   }


    public static void main(String[] args) {

        new Thread() {
            public void run() {                
                
                GLCanvas canvas = new GLCanvas();                
                Frame frame = new Frame("OCTAEDROS EN EL ESPACIO");
                frame.setSize(700, 700);
                frame.add(canvas);
                frame.setVisible(true);
                final Octaedro[] octaedros = new Octaedro[3];
                
                octaedros[0] = new Octaedro(1f, 0, 1, 0,   0f, -3f, 0f); 
                octaedros[1] = new Octaedro(1f, 1, -1, 0,  0f, -3f, 0f); 
                octaedros[2] = new Octaedro(1f, -1, -1, 0,  0f, -3f, 0); 

               
                canvas.addGLEventListener(new GLEventListener() {
                    @Override
                    public void display(GLAutoDrawable drawable) {
                        update();
                        render(drawable);
                    }

                    @Override
                    public void init(GLAutoDrawable drawable) {
                    }

                    public void render(GLAutoDrawable drawable) {
                        GL gl = drawable.getGL();

                        gl.glMatrixMode(gl.GL_PROJECTION);
                        gl.glLoadIdentity();                        
                        gl.glOrtho(-10, 10, -10, 10, -1000, 1000);                        
                        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
                        gl.glEnable(GL.GL_DEPTH_TEST);
                        gl.glDepthFunc(GL.GL_LEQUAL);
                        gl.glMatrixMode(GL.GL_MODELVIEW);                        
                        
                        
                        for(Octaedro object:octaedros)
                            object.draw(drawable);

                    }

                    public void update() {
                        for(Octaedro object:octaedros)
                            object.update();
                    }

                    @Override
                    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
                        drawable.getGL().glViewport(0, 0, arg3, arg4);
                    }

                    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
                        
                    }
                });
                              
                canvas.addMouseMotionListener(new MouseMotionListener() {
                        
                    public void mouseDragged(MouseEvent me) {
                        
                            //System.out.println("CALCULANDO");
                           int ax = me.getX();
                           int ay = me.getY();
                           ydir = ax-mousex;
                           
                           
                           
                           xdir = ay-mousey;
                           
                           
                           mousex = ax;
                           mousey = ay;
                        
                    }

                    public void mouseMoved(MouseEvent me) {
                    
                    }

                });

                
                frame.addWindowListener(new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                while (true) {
                    try {
                        Thread.sleep(1000 / 60);                        
                        for(Octaedro object:octaedros)
                            object.update();
                        canvas.repaint();
                        xdir = 0;
                        ydir = 0;
                    } catch (Exception e) {

                    }
                }
            }
        }.start();


        // Terminate the program when the window is asked to close
    }
}
