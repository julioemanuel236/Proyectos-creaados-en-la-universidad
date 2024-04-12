

package psj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Date;
import java.util.HashMap;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.*;


public class psj extends JFrame{

    JPanel menu = new JPanel();
    JPanel nuevoh = new JPanel();
    JPanel nuevoe = new JPanel(); 
    JPanel nuevoc = new JPanel();
    JPanel funciones = new JPanel();
    JScrollPane view = new JScrollPane();
    JTextField nuevotxt[] = new JTextField[5];
    JTextField empleadotxt[] = new JTextField[6];
    JTextField clientetxt[] = new JTextField[8];
    LinkedList<empleado> empleados = new LinkedList<>();     
    LinkedList<hotel> hoteles = new LinkedList<>();
    LinkedList<cliente> clientes = new LinkedList<>();
	JTextArea mostrar = new JTextArea();
	JScrollPane v = new JScrollPane(mostrar);
	
    private class hotel{
        String nombre;
        int capacidad;
        int categoria;
        LinkedList<String> servicios = new LinkedList<String>();
        HashMap<String,BigDecimal> paises;
        
        public hotel(String n,int cp,int ct,LinkedList<String> ser,HashMap<String,BigDecimal> p){
            this.nombre=n;
            capacidad=cp;
            categoria=ct;
            servicios=ser;
            paises=p;
        }
        
    }
    
    private class persona{
        String nombre;
        String ID;
        String sex;
    }
    
    private class empleado extends persona{
        BigDecimal tiempolaboral;
        boolean jefe;
        BigDecimal tiempojefe;
        LinkedList<habitacion> habitaciones = new LinkedList<>();
        BigDecimal salario;
        
        public empleado(String nombre,String id,String sex,String tiempol,String jefe,String tiepmoje,String salario) {
        	this.nombre=nombre;
        	ID=id;
        	this.sex=sex;
        	this.tiempolaboral= new BigDecimal(tiempol);
        	this.jefe = (jefe.equals("si")?true:false);
        	this.tiempojefe= new BigDecimal(tiepmoje);
        	this.salario = new BigDecimal(salario);
        }
        
        public BigDecimal pago() {
        	BigDecimal pag=salario.multiply(new BigDecimal(24));
        	BigDecimal plusbase = new BigDecimal("0.1").multiply(tiempolaboral);
        	if(jefe) {
        		BigDecimal plus=tiempojefe.multiply(new BigDecimal("0.1")).add(new BigDecimal(150));
        		return pag.add(plus.add(plusbase));
        	}
        	BigDecimal plus= new BigDecimal(100);
        	return pag.add(plus.add(plusbase));
        }
        
    }
    
    private class habitacion{
      int numero;
      int planta;
      empleado encarado;
      int tipo;
      int precio;
    }
    
    private class cliente extends persona{
        String pais;
        boolean vip;
        String cargo;
        habitacion hospedaje;
        Date fll;
        Date fsl;
        BigDecimal precio;
        public cliente(String n,String i,String pais,String vip,String cargo,String p,String fl,String fs) {
        	nombre=n;
        	ID=i;
        	this.pais=pais;
        	this.vip=(vip.equals("si")?true:false);
        	this.cargo=cargo;
        	this.precio = new BigDecimal(p);
        	
        }
    }
    
    public psj(){
        this.setSize(900,500);
        this.setLayout(null);
        menu();
        nuevopanel(nuevoh,nuevotxt,new String[]{"Nombre del hotel","categoria","capacidad","servicios","pais que intervien"});
        nuevopanel(nuevoe,empleadotxt,new String[]{"Nombre","carnet de identidad","sexo","anos de trabajo","jefe de piso","tiempo en el cargo","salario"});        
        nuevopanel(nuevoc,clientetxt,new String[]{"Nombre","carnet de identidad","pais","vip","cargo","precio de la habitacion","Fecha de ingreso","Fecha de ida"});
        nuevopanel(funciones,null,new String[] {"Ganancia de la cadena","Pais con mas ganancias","Clientes vip","Clientes en fecha","Salario Empleados","Pais con mas turistas"});
        view();
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
    private void view(){
        view.setSize(nuevoh.getSize());
        view.setLocation(menu.getWidth(),0);
        view.setViewportView(nuevoh);
        view.setOpaque(true);
        this.add(view);
    }
    
    private void nuevopanel(final JComponent j,final JTextField[] arrt,final String s[]){
        
        j.setSize(this.getWidth()-menu.getWidth(),this.getHeight()-20);
        j.setOpaque(true);
        j.setBackground(java.awt.Color.black);
        j.setLayout(null);
        if(((JPanel)j).equals(nuevoh))nuevohotel(j,arrt,s);
        else if(((JPanel)j).equals(nuevoe))nuevoempleado(j,arrt,s);
        else if(((JPanel)j).equals(funciones))nuevofunciones(j,s);
        else if(((JPanel)j).equals(nuevoc))nuevocliente(j,arrt,s);
    }
    
    private void nuevofunciones(JComponent j,String[] s) {

    	
    	v.setSize(nuevoh.getWidth(),nuevoh.getHeight());
    	mostrar.setSize(v.getWidth()-10,10000000);
    	v.validate();
    	v.setLocation(255,0);
    	j.add(v);
    	for(int i=0;i<s.length;i++){
            JButton op = new JButton(s[i]);
            if(s[i].equals("Salario Empleados")) {
            	op.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						for(empleado i:empleados) {
							mostrar.setText(mostrar.getText()+i.ID+" $"+i.pago()+"\n");
						}
						
					}
            		
            	});
            }
            op.setSize(250,25);
            op.setBorder(null);
            op.setLocation(5,5+(30*i));
            j.add(op);
    	}
    }
    
    private void nuevoempleado(final JComponent j,final JTextField[] arrt,final String s[]){
    	for(int i=0;i<arrt.length;i++){
            arrt[i] = new JTextField(s[i]);
            arrt[i].setSize(250,25);
            arrt[i].setBorder(null);
            arrt[i].setLocation(5,5+(30*i));
            j.add(arrt[i]);
    	}
    	
        JButton aceptar = new JButton("Aceptar");
        aceptar.setSize(150,40);
        aceptar.setLocation(j.getWidth()-aceptar.getWidth()-40,j.getHeight()-aceptar.getHeight()-40);
        j.add(aceptar);
        if(j.equals(nuevoe)){
            aceptar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    empleado emp = new empleado(arrt[0].getText(),arrt[1].getText(),arrt[2].getText(),arrt[3].getText(),arrt[4].getText(),arrt[5].getText(),arrt[5].getText());
                    System.out.println(emp.nombre+" "+emp.salario);
                    //System.out.println(h.nombre);
                    empleados.add(emp);
                }
            });
        }
    }
    
    private void nuevocliente(final JComponent j,final JTextField[] arrt,final String s[]){
    	for(int i=0;i<arrt.length;i++){
            arrt[i] = new JTextField(s[i]);
            arrt[i].setSize(250,25);
            arrt[i].setBorder(null);
            arrt[i].setLocation(5,5+(30*i));
            j.add(arrt[i]);
    	}
    	
        JButton aceptar = new JButton("Aceptar");
        aceptar.setSize(150,40);
        aceptar.setLocation(j.getWidth()-aceptar.getWidth()-40,j.getHeight()-aceptar.getHeight()-40);
        j.add(aceptar);
            aceptar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    cliente cliente = new cliente(arrt[0].getText(),arrt[1].getText(),arrt[2].getText()
                    							  ,arrt[3].getText(),arrt[4].getText(),arrt[5].getText(),
                    							   arrt[6].getText(),arrt[7].getText());
                    System.out.println(cliente.nombre+" "+cliente.pais);
                    //System.out.println(h.nombre);
                    clientes.add(cliente);
                    System.out.println("anadio ina mama ahgi "+clientes.size());
                }
            });
        
    }
    
    private void nuevohotel(final JComponent j,final JTextField[] arrt,final String s[]){
    	LinkedList<String> servicios = new LinkedList<>();
        HashMap<String,BigDecimal> paises = new HashMap<>();
        
        for(int i=0;i<arrt.length;i++){
            arrt[i] = new JTextField(s[i]);
            arrt[i].setSize(250,25);
            arrt[i].setBorder(null);
            arrt[i].setLocation(5,5+(30*i));
            if(s[i].equals("servicios")||s[i].equals("pais que intervien")){
                JButton plus = new JButton("Anadir");
                plus.setSize(120,25);
                plus.setLocation(arrt[i].getX()+arrt[i].getWidth()+5,arrt[i].getY());
                j.add(plus);
                String t = new String(s[i]);
                if(t.equals("servicios")){
                     plus.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){       
                            servicios.add(t);
                        }
                    });
                }
                else if(t.equals("pais que intervien")){
                    arrt[i].setSize(225,25);
                    JTextField tt = new JTextField("0");
                    tt.setLocation(arrt[i].getWidth()+arrt[i].getX(),arrt[i].getY());
                    tt.setSize(25,25);
                    j.add(tt);
                    plus.setLocation(plus.getX(),plus.getY());
                    BigDecimal bd = new BigDecimal(tt.getText()) ;
                    
                    plus.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){       
                            paises.put(t,bd);
                        }
                    });
                }
            }
           j.add(arrt[i]);
        }
        JButton aceptar = new JButton("Aceptar");
        aceptar.setSize(150,40);
        aceptar.setLocation(j.getWidth()-aceptar.getWidth()-40,j.getHeight()-aceptar.getHeight()-40);
        j.add(aceptar);
        if(j.equals(nuevoh)){
            aceptar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    hotel h = new hotel(arrt[0].getText(),new Integer(arrt[1].getText()),new Integer(arrt[2].getText()),servicios,paises);
                    //System.out.println(h.nombre);
                    hoteles.add(h);
                }
            });
        }
    }
    
    private void menu(){
        menu.setSize(100,this.getHeight());
        menu.setLocation(0,0);
        menu.setOpaque(true);
        menu.setBackground(java.awt.Color.darkGray);
        this.add(menu);
        JButton newh = new JButton("Nuevo Hotel");
        newh.setSize(menu.getWidth(),40);
        newh.setLocation(0,0);
        vista(newh,nuevoh);
        menu.add(newh);
        JButton newe = new JButton("Nuevo Empleado");
        newe.setSize(menu.getWidth(),40);
        newe.setLocation(45,0);
        vista(newe,nuevoe);
        menu.add(newe);
        
        JButton newc = new JButton("Nuevo Cliente");
        newc.setSize(menu.getWidth(),40);
        newc.setLocation(45,0);
        vista(newc,nuevoc);
        menu.add(newc);
        
        JButton verpago = new JButton("Ver Pagos");
        newe.setSize(verpago.getWidth(),40);
        newe.setLocation(45,0);
        vista(verpago,funciones);
        menu.add(verpago);
        
        JButton guardar = new JButton("Guardar Datos Clientes");
        guardar.setSize(verpago.getWidth(),40);
        guardar.setLocation(45,0);
        menu.add(guardar);
        guardar.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		String s = "TUMAMA.txt";
                FileWriter fw;
                try{

                      fw= new FileWriter(s);
                      System.out.println(clientes.size());
                      for(cliente i:clientes) {
                    	  fw.append(i.toString()+"\n");
                      }
                      fw.close();
                }
                catch(Exception io){
                      //l3.setText("Error al abrir el fichero");
                      return;
                }
                /*try{
                    
                      //l3.setText("Fichero guardado");
                }
                catch(IOException io){
                      //l3.setText("Error al escribir");
                }
                try{
                      
                }
                catch(IOException io){
                    //  l3.setText("Error al cerrar el archivo");
                } */            
          }
        });

    }
    
    private void vista(JButton b,JPanel p){
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               view.setViewportView(p);
            }
        });
           
    }
   
    public static void main(String[] args) {
        new psj();
    }

}
