package app;

import controllers.Controller;
import models.Model;
import views.View;

import javax.swing.*;
import java.io.File;

/**
 * Siin klassis on meetod mida Java Virtual Machine (JVM) otsib (main). Sellest meetodist käivitaatakse rakendus
 */
public class MainApp {
    /**
     * Klassi MainApp konstruktor
     */
    public MainApp(String dbName) {

        initializeUI(dbName); // Loob GUI
    }

    /**
     * See meetod loob tegelikkuses kogu rakenduse.
     */
    private void initializeUI(String dbName) {
        Model model = new Model(dbName);
        View view = new View(model); // Loome JFrame ja kõik JPanel ja sinna peale minevad JComponents
        new Controller(model, view);//Loome kontrolleri nuppude ja Comboboxi jaoks

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFRame sulgemis nupu tegevus (Sulge)
        view.pack(); // "Raputa" komponendid paika
        view.setLocationRelativeTo(null); // JFRame asukoht (ekraani keskel)
        view.setVisible(true); // Tee JFrame nähtavaks
    }

    /**
     * Meetod millega käivitatakse rakendus
     * @param args käsurealt loetavad argumendid (teise andmebaasi kasutamine)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String dbName = null;
                if(args.length >= 1) {//Käsurel on lisa infot (meid huvitab esimene)
                    File file = new File(args[0]);//Teeme käsureal stringi File objektiks
                    if(file.exists() && !file.isDirectory()) {
                        //File on olemas ja see pole kaust
                        dbName = args[0];
                    }
                }
                new MainApp(dbName);
            }
        });
    }
}
