package fr.univ_tln.bruno.tp.tp4;

import fr.univtln.bruno.coursjava.tp.tp2.animal.Animal;
import fr.univtln.bruno.coursjava.tp.tp2.animal.mammifere.Chien;

import java.io.*;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ChienExportable chien1 = new ChienExportable("Médor", Animal.Sexe.MALE, 9);
        ChienExportable chien2 = new ChienExportable("Rex", Animal.Sexe.MALE, 9);

        File file = new File("fichier.data");
        System.out.println(file.getAbsolutePath());

        FileOutputStream fos = null;
        try {
            chien1.sauver(fos = new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Chien 2 d'origine :" + chien2);

        FileInputStream fis = null;
        try {
            chien2.lire(fis = new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Chien2 après mise à jour avec fichier :" + chien2);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("fichier2.data"));
            oos.writeObject(chien2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;
        try {
            Chien c;
            ois = new ObjectInputStream(new FileInputStream("fichier2.data"));
            c = (Chien) ois.readObject();
            System.out.println("Chien lu après deserialisation :" + c.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
