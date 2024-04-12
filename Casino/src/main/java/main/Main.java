package main;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;

public class Main {

    public static void main(String[] args){
        try {
            //ponerle que se vea bonito :D
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ventanas.Principal(new Entidades.Data()).setVisible(true);
    }
}
