package fr.univ_tln.bruno.tp.tp4.ihm;

import fr.univtln.bruno.coursjava.tp.tp2.animal.Animal;
import fr.univtln.bruno.tp.tp3.AnimalTatoue;

import javax.swing.*;
import java.awt.*;

public class Ihm extends JFrame {

    private VueAnimal vueChien = new VueAnimal();

    public Ihm() {
        setSize(640, 480);
        getContentPane().add(vueChien, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        Ihm ihm = new Ihm();
        ModeleAnimal modeleAnimal = new ModeleAnimal();
        modeleAnimal.addObserver(ihm.vueChien);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

}
