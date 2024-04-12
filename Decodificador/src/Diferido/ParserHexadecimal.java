//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Diferido;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParserHexadecimal {
    int numTramas;
    int num_trama = 0;
    int inc_Tiempo = 0;
    String idGPS = "";
    int Num_pos;
    int Anno;
    int Tiempo;
    int Latitud;
    int Longitud;
    int Distancia_dg;
    String odom1 = "";
    Date f3 = new Date();
    String tiempo_wnro = "";
    String fecha_anterior = "";
    File mifile;
 //   Entrada en;

    public ParserHexadecimal(/*Entrada en*/) {
        //this.en = en;
        this.f3 = this.Fecha_Hora_Actual();
    }

    public String Fechasat(int fechax, int anno) throws ParseException {
        String fecha = null;
        int a = anno + 1980 - 1900;
        int mes = 0;
        int dia = 1;
        Date now = new Date(a, mes, dia);
        now.setSeconds(fechax);
        long nowLong = now.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyy,HHmmss");
        Date f2 = new Date(nowLong);
        if (this.f3.getYear() - f2.getYear() <= 18) {
            fecha = formato.format(f2);
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(f2);
            c.add(6, 7168);
            fecha = formato.format(c.getTime());
        }

        return fecha;
    }

    public Date Fecha_Hora_Actual() {
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        dateformat.format(date);
        return date;
    }

    public void SegundosAnno(Date fechax) throws ParseException {
        int a = fechax.getYear();
        int mes = fechax.getMonth();
        int dia = fechax.getDay();
        Date now = new Date(a, mes, dia);
        long nowLong = now.getTime() / 1000L;
    }

    public byte[] hexToBytes(char[] hex) {
        int length = hex.length / 2;
        byte[] raw = new byte[length];

        for(int i = 0; i < length; ++i) {
            int high = Character.digit(hex[i * 2], 16);
            int low = Character.digit(hex[i * 2 + 1], 16);
            int value = high << 4 | low;
            if (value > 127) {
                value -= 256;
            }

            raw[i] = (byte)value;
        }

        return raw;
    }

    public String leerTramaOriginal(BitInputStream bin) {
        String cad = null;
        System.out.println("BIT INPUT STREAM bin:\n"+bin.toString());
        
        try {
        	System.out.println();
            this.Num_pos = bin.readBits(8);
            this.Anno = bin.readBits(6);
            this.Tiempo = bin.readBits(25);
            int rumbo_dg = bin.readBits(6);
            int Edad_Posici�n = bin.readBits(1);
            this.Latitud = bin.readBits(32);
            this.Longitud = bin.readBits(32);
            int Velocidad = bin.readBits(6);
            this.Distancia_dg = bin.readBits(20);
            int C�digoAlarma = bin.readBits(8);
            int Parado_movimiento = bin.readBits(1);
            String Tiempo1 = this.Fechasat(this.Tiempo, this.Anno);
            String lat = String.valueOf(this.Latitud);
            String p = lat.substring(0, 2) + "." + lat.substring(2, lat.length()).trim();
            String lon = String.valueOf(this.Longitud);
            String t = lon.substring(0, 3) + "." + lon.substring(3, lon.length()).trim();
            int rumbo = rumbo_dg * 10;
            int Distancia_acumulada = this.Distancia_dg * 10;
            cad = this.idGPS + "," + Tiempo1 + "," + rumbo + "," + Edad_Posici�n + "," + p + "," + t + "," + Velocidad + "," + Distancia_acumulada + "," + C�digoAlarma + "," + Parado_movimiento + "\n";
            System.out.println("Num_pos: "+Num_pos);
            System.out.println("Anno: "+Anno);
            System.out.println("Tiempo: "+Tiempo +new Date(Tiempo).toString());
            System.out.println("rumbo_dg: "+rumbo_dg);
            System.out.println("Edad_Posici�n: "+Edad_Posici�n);
            System.out.println("Latitud: "+Latitud);
            System.out.println("Longitud: "+Longitud);
            System.out.println("Velocidad: "+Velocidad);
            System.out.println("Distancia_dg: "+Distancia_dg);
            System.out.println("C�digoAlarma: "+C�digoAlarma);
            System.out.println("Parado_movimiento: "+Parado_movimiento);
            System.out.println("Tiempo1: "+Tiempo1);
            System.out.println("lat: "+lat);
            System.out.println("p: "+p);
            System.out.println("lon: "+lon);
            System.out.println("t: "+t);
            System.out.println("rumbo: "+rumbo);
            System.out.println("Distancia_acumulada: "+Distancia_acumulada);
            System.out.println();
            //System.out.println(cad);
        } catch (Exception var15) {
        }

        return cad;
    }

    public String leerTramaIncremental(BitInputStream bin) {
        String cad = null;
        
        try {
            int inc_tiem = bin.readBits(12);
            this.Tiempo += inc_tiem;
            int rumbo_dg = bin.readBits(6);
            int ed_po = bin.readBits(1);
            int inc_lat = bin.readBits(18);
            int inc_lon = bin.readBits(18);
            if (inc_lat > 131072) {
                this.Latitud -= (inc_lat ^ 262143) + 1;
            } else {
                this.Latitud += inc_lat;
            }

            if (inc_lon > 131072) {
                this.Longitud -= (inc_lon ^ 262143) + 1;
            } else {
                this.Longitud += inc_lon;
            }

            int Velocidad1 = bin.readBits(6);
            int inc_dist = bin.readBits(13);
            this.Distancia_dg += inc_dist;
            int cod_alar = bin.readBits(8);
            int ind_mov = bin.readBits(1);
            String Tiempo2 = this.Fechasat(this.Tiempo, this.Anno);
            String lat = String.valueOf(this.Latitud);
            String p = lat.substring(0, 2) + "." + lat.substring(2, lat.length()).trim();
            String lon = String.valueOf(this.Longitud);
            String t = lon.substring(0, 3) + "." + lon.substring(3, lon.length()).trim();
            int rumbo = rumbo_dg * 10;
            int Distancia_acumulada = this.Distancia_dg * 10;
            cad = this.idGPS + "," + Tiempo2 + "," + rumbo + "," + ed_po + "," + p + "," + t + "," + Velocidad1 + "," + Distancia_acumulada + "," + cod_alar + "," + ind_mov + "\n";
            if (this.num_trama == 1) {
                this.inc_Tiempo = inc_tiem;
            }
            System.out.println("INCREMENTAL");
            System.out.println("Num_pos: "+Num_pos);
            System.out.println("Anno: "+Anno);
            System.out.println("Tiempo: "+Tiempo + new Date(Tiempo).toString());
            System.out.println("rumbo_dg: "+rumbo_dg);
//            System.out.println("Edad_Posici�n: "+Edad_Posici�n);
            System.out.println("Latitud: "+Latitud);
            System.out.println("Longitud: "+Longitud);
 //           System.out.println("Velocidad: "+Velocidad);
 //           System.out.println("Distancia_dg: "+Distancia_dg);
//            System.out.println("C�digoAlarma: "+C�digoAlarma);
//            System.out.println("Parado_movimiento: "+Parado_movimiento);
//            System.out.println("Tiempo1: "+Tiempo1);
            System.out.println("lat: "+lat);
            System.out.println("p: "+p);
            System.out.println("lon: "+lon);
            System.out.println("t: "+t);
            System.out.println("rumbo: "+rumbo);
            System.out.println("Distancia_acumulada: "+Distancia_acumulada);
            System.out.println();
        } catch (Exception var19) {
        }

        return cad;
    }

    public void replaceAllNull(File newfile) {
        String cont = null;

        try {
            FileInputStream fis = new FileInputStream(newfile);
            StringBuilder sb = new StringBuilder();

            for(int c = fis.read(); c != -1; c = fis.read()) {
                sb.append((char)c);
            }

            cont = sb.toString();
            cont = cont.toString().replaceAll("\u0000", "").trim();
            this.CopiarDesdeHasta(cont);
        } catch (Exception var6) {
        }

    }

    public void CopiarDesdeHasta(String hexad) throws FileNotFoundException, IOException {
        String linea = "";
        String f = "";
        String filtro = f.trim();
        boolean inicio = false;
        BufferedReader bufferedReader = new BufferedReader(new StringReader(hexad));
        int i = 0;

        while(true) {
            do {
                do {
                    if ((linea = bufferedReader.readLine()) == null) {
                        bufferedReader.close();
                        if (filtro.startsWith("***") && filtro.endsWith("*****")) {
                            this.LeerHexadecimal(filtro);
                        } else {
                            String Mensaje = "Verifique que el Hist�rico comience con *** y termine con ******.<br/>P�ngase en contacto con el personal de GCOM<br/>La Aplicaci�n se cerrar�.";
                     //       this.en.ShowMessage(Mensaje, "Error", "Error");
                            System.exit(0);
                        }

                        return;
                    }
                } while(linea.equalsIgnoreCase(""));

                if (linea.startsWith("Trama Guardada")) {
                    linea = linea.replaceAll("Trama Guardada", "").trim();
                } else if (linea.startsWith("Enviar Historico")) {
                    linea = linea.replaceAll("Enviar Historico", "").trim();
                } else if (linea.startsWith("Mens Buf TCP Bad")) {
                    linea = linea.replaceAll("Mens Buf TCP Bad", "").trim();
                } else if (linea.startsWith("Error Desconexion APN")) {
                    linea = linea.replaceAll("Error Desconexion A bPN", "").trim();
                } else if (linea.startsWith("SIMCOM Desconectando APN")) {
                    linea = linea.replaceAll("SIMCOM Desconectando APN", "").trim();
                } else if (linea.startsWith("Orden de Guardar en Flash")) {
                    linea = linea.replaceAll("Orden de Guardar en Flash", "").trim();
                } else if (linea.startsWith("TRetardo: 64292")) {
                    linea = linea.replaceAll("TRetardo: 64292", "").trim();
                }

                linea = linea.trim();
                if (linea.startsWith("***")) {
                    inicio = true;
                }
            } while(!inicio && !linea.endsWith("******"));

            filtro = filtro + linea;
            if (linea.endsWith("******")) {
                inicio = false;
            }
        }
    }

    public void LeerHexadecimal(String hexad) {
    	System.out.println("LETENDO "+hexad);
        int acumulado = 0;
/*        this.en.PB.setVisible(true);
        this.en.PBLabel.setText("Lectura del Registro Hist�rico...");
        this.en.PBLabel.setVisible(true);*/
        System.out.println("Lectura del Registro Hist�rico...");
        this.mifile = new File("Temp\\TextoHex.xml");
        String[] partesRegistro = new String[350];
        BufferedReader bufferedReader = new BufferedReader(new StringReader(hexad));

        String linea;
        try {
            while((linea = bufferedReader.readLine()) != null) {
                linea = linea.replace("***", "").trim();
                partesRegistro = linea.split("#");
                int p = (partesRegistro.length - 1) / 2;
                String Id_noTramas = partesRegistro[0].trim();

                String Mensaje;
                String lin;
                try {
                    if (Id_noTramas.length() > 5) {
                        this.idGPS = Id_noTramas.substring(0, 5).trim();
                        this.numTramas = Integer.parseInt(Id_noTramas.substring(5, Id_noTramas.length()));
                    } else {
                        Mensaje = "Verifique que el id del GPS sea correcto. P�ngase<br/>en contacto con el personal de GCOM o con el Puesto<br/>de Mando de GEOCUBA para arreglar la situaci�n.";
 //                       this.en.ShowMessage(Mensaje, "Error", "Error");
                        System.exit(0);
                    }
                } catch (Exception var17) {
                    System.out.println(var17);
                    lin = "Verifique que el id del GPS sea correcto. P�ngase<br/>en contacto con el personal de GCOM o con el Puesto<br/>de Mando de GEOCUBA para arreglar la situaci�n.";
//                    this.en.ShowMessage(lin, "Error", "Error");
                    System.exit(0);
                }

                if (p != this.numTramas) {
                    Mensaje = "El N�mero de Registros no coincide con la cantidad<br/>Descargada. P�ngase en contacto con el personal de GCOM<br/>o con el Puesto de Mando de GEOCUBA para arreglar la situaci�n.";
 //                   this.en.ShowMessage(Mensaje, "Error", "Error");
                    System.exit(0);
                } else {
                    for(int i = 2; i < partesRegistro.length; i += 2) {
                    	System.out.println("ANALIZANDO PARTE "+i);
                        if (this.Tiempo > 1704787) {
                            String var6 = "stop";
                        }

                        lin = partesRegistro[i];
                        System.out.println("lin "+lin);
                        byte[] buf = this.hexToBytes(lin.toCharArray());
                        if (buf.length != 174) {
                            System.out.println(buf.length + "\n");
                        } else {
                            InputStream is = new ByteArrayInputStream(buf);
                            BitInputStream bin = new BitInputStream(is);
                            String o = this.leerTramaOriginal(bin);
//                            this.en.Insertar_fichero(o, this.mifile);
                            ++this.num_trama;
                            if (this.Num_pos == -1) {
                                return;
                            }

                            int k;
                            String d;
                            if (this.Num_pos == 16) {
                                for(k = 0; k < this.Num_pos - 1; ++k) {
                                    d = this.leerTramaIncremental(bin);
                                    
  //                                  this.en.Insertar_fichero(d, this.mifile);
                                }
                            } else if (this.Num_pos < 16) {
                                for(k = 0; k < 15; ++k) {
                                    d = this.leerTramaIncremental(bin);
                                    if (k < this.Num_pos - 1) {
//                                        this.en.Insertar_fichero(d, this.mifile);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception var18) {
            System.out.println(var18);
        }

    }

    public void LeerBinario(File binario) throws IOException {
        this.mifile = new File("Temp\\TextoBin.xml");
        BitInputStream bin = new BitInputStream(binario);

        while(true) {
            while(bin.markSupported()) {
                bin.resetFile();
                this.Num_pos = bin.readBits(8);
                if (this.Num_pos == -1) {
                    return;
                }

                String o = this.leerTramaOriginal(bin);
//                this.en.Insertar_fichero(o, this.mifile);
                System.out.println(o);
                int k;
                String d;
                if (this.Num_pos == 16) {
                    for(k = 0; k < this.Num_pos - 1; ++k) {
                        d = this.leerTramaIncremental(bin);
//                        this.en.Insertar_fichero(d, this.mifile);
                        System.out.println(d);
                    }
                } else if (this.Num_pos < 16) {
                    for(k = 0; k < 15; ++k) {
                        d = this.leerTramaIncremental(bin);
                        if (k < this.Num_pos - 1) {
//                            this.en.Insertar_fichero(d, this.mifile);
                            System.out.println(d);
                        }
                    }
                }
            }

            bin.close();
            return;
        }
    }
    
    
    public static void main(String args[]) {
    	ParserHexadecimal ph = new ParserHexadecimal();
    	try {
			ph.replaceAllNull(new File("G34581020094221.log"));
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}