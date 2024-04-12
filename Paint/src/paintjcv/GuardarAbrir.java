
package paintjcv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class GuardarAbrir {

    public void guardar(Dibujar canvas1, ArrayList<AtributosFormas> atributos) {
        try {
            JFrame parentFrame = new JFrame();

            // Clase de java para buscar archivos
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivos...");
            // Directorio actual q va a abrir por defauld
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            int userSelection = fileChooser.showSaveDialog(parentFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                File fileToSave2 = fileChooser.getSelectedFile();

                if (fileToSave == null) {
                    return;
                }
                if (!fileToSave.toString().toLowerCase().endsWith(".txt")) {
                    String archivo_texto = armarTexto(atributos);
                    fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".txt");
                    fileToSave2 = new File(fileToSave2.getParentFile(), fileToSave2.getName() + ".png");

                    BufferedImage image = new BufferedImage(canvas1.getWidth(), canvas1.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    Graphics g = image.getGraphics();
                    canvas1.paint(g);

                    // Guarda la foto
                    ImageIO.write(image, "png", new File(fileToSave2.getAbsolutePath()));

                    // Guarda el archivo de texto en la ruta especificada  
                    Files.write(Paths.get(fileToSave.getAbsolutePath()), archivo_texto.getBytes());
                }

            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private String armarTexto(ArrayList<AtributosFormas> atributos) {

        try {
            String resultado = "";

            for (int i = 0; i < atributos.size(); i++) {

                resultado = resultado + Integer.toString(atributos.get(i).getX()) + ";" + Integer.toString(atributos.get(i).getY()) + ";"
                        + Integer.toString(atributos.get(i).getX1()) + ";" + Integer.toString(atributos.get(i).getY1()) + ";"
                        + Integer.toString(atributos.get(i).getGrosor()) + ";" + Integer.toString(atributos.get(i).getTipo()) + ";"
                        + Integer.toString(atributos.get(i).getColor().getRGB()) + ";";

                if (i < (atributos.size() - 1)) {
                    resultado = resultado + "\n";
                }

            }

            return resultado;

        } catch (Exception ex) {
            return "";
        }
    }

    public ArrayList<AtributosFormas> abrir() {
        try {
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Abrir archivo...");
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            // Pone un filtro para q solo sean los archivos txt
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);

            int userSelection = fileChooser.showOpenDialog(parentFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                if (fileToSave == null) {
                    return null;
                }
                if (fileToSave.toString().toLowerCase().endsWith(".txt")) {

                    InputStream is = new FileInputStream(fileToSave.getAbsolutePath());
                    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
                    ArrayList<AtributosFormas> formas = new ArrayList<>();
                    AtributosFormas forma;

                    String line = buf.readLine();
                    StringBuilder sb = new StringBuilder();

                    while (line != null) {

                        sb.append(line).append("\n");
                        line = buf.readLine();
                    }

                    String fileAsString = sb.toString();
                    
                    String[] lineas = fileAsString.split("\n", -1);

                    for (int i = 0; i < lineas.length - 1; i++) {
                        String[] array = lineas[i].split("\\;", -1);
                        Color c = new Color(Integer.parseInt(array[6]));
                        forma = new AtributosFormas(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]),
                                Integer.parseInt(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]), c);

                        formas.add(forma);
                    }

                    return formas;
                }
            }
            return null;

        } catch (Exception ex) {
            return null;
        }
    }
}
