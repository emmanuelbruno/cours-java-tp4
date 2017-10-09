package fr.univ_tln.bruno.tp.tp4.ihm;

import fr.univtln.bruno.coursjava.tp.tp2.animal.Animal.Sexe;
import fr.univtln.bruno.tp.tp3.AnimalTatoue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

public class VueAnimal extends JPanel implements Observer {
    private final ControlleurAnimal controllerChien;
    protected JLabel jl_nom = new JLabel("Nom");
    protected JLabel jl_sexe = new JLabel("Sexe");
    protected JButton jb_creer = new JButton("Ajouter");

    protected JTextField jtf_nom = new JTextField(10);
    protected JRadioButton jrb_male = new JRadioButton("Mâle");

    protected JRadioButton jrb_femelle = new JRadioButton("Femelle");

    protected ButtonGroup bg_sexe = new ButtonGroup();

    protected DefaultComboBoxModel<AnimalTatoue> animalTatoueDefaultComboBoxModel = new DefaultComboBoxModel<>();
    protected JList<AnimalTatoue> animalTatoueJList = new JList<>(animalTatoueDefaultComboBoxModel);

    public VueAnimal() {
        ModeleAnimal modeleAnimal = new ModeleAnimal();
        modeleAnimal.addObserver(this);
        controllerChien = new ControlleurAnimal(modeleAnimal, this);

        jrb_male.setMnemonic(KeyEvent.VK_M);
        jrb_male.setActionCommand("MALE");

        jrb_femelle.setMnemonic(KeyEvent.VK_F);
        jrb_femelle.setActionCommand("FEMELLE");

        bg_sexe.add(jrb_male);
        bg_sexe.add(jrb_femelle);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2, 2, 2, 2);
        add(jl_nom, c);
        c.gridx = 1;
        add(jtf_nom, c);

        c.gridx = 0;
        c.gridy = 1;
        add(jrb_femelle, c);
        c.gridx = 1;
        add(jrb_male, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 3;
        add(jb_creer, c);

        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 3;
        JScrollPane jScrollPaneListAnimal = new JScrollPane();
        jScrollPaneListAnimal.setViewportView(animalTatoueJList);
        add(jScrollPaneListAnimal, c);

        jb_creer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerChien.creerAnimal(jtf_nom.getText(), Sexe.valueOf(bg_sexe.getSelection().getActionCommand()));
            }
        });
    }


    public void rafraichirListe() {
        animalTatoueDefaultComboBoxModel.removeAllElements();
        controllerChien.getListeAnimaux().forEach(x-> {System.out.println(x);animalTatoueDefaultComboBoxModel.addElement(x);});
    }

    public ControlleurAnimal getControllerChien() {
        return controllerChien;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Model changed");
        rafraichirListe();
    }
}
