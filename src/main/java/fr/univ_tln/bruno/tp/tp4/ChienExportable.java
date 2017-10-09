package fr.univ_tln.bruno.tp.tp4;

import fr.univtln.bruno.coursjava.tp.tp2.animal.mammifere.Chien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChienExportable extends Chien {
    public ChienExportable(String nom, Sexe sexe, int dureeGestation) {
        super(nom, sexe, dureeGestation);
    }

    public void sauver(String filename) throws IOException {
        File file=new File(filename);
        sauver(file);
    }

    public void sauver(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        sauver(fos);
        fos.close();
    }

    public void lire(String filename) throws IOException {
        File file=new File(filename);
        sauver(file);
    }

    public void lire(File file) throws IOException {
        FileInputStream fis=new FileInputStream(file);
        lire(fis);
        fis.close();
    }

    public void sauver(OutputStream outputStream) throws IOException {
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.writeUTF(getNom());
        dos.writeUTF(getSexe().name());
        dos.writeInt(getDureeGestation());
    }

    public List<ChienExportable> lire(InputStream inputStream) {
        DataInputStream dos = new DataInputStream(inputStream);
        List<ChienExportable> chiens = new ArrayList<>();
        try {
            while (true) {
                chiens.add(new ChienExportable(dos.readUTF(), Sexe.valueOf(dos.readUTF()), dos.readInt()));
            }
        } catch (IOException e) {}
        return chiens;
    }
}
