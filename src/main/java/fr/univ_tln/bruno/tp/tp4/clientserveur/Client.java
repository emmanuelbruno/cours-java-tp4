package fr.univ_tln.bruno.tp.tp4.clientserveur;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import fr.univ_tln.bruno.tp.tp4.Personne;
import fr.univtln.bruno.coursjava.tp.tp2.animal.Animal;
import fr.univtln.bruno.coursjava.tp.tp2.animal.mammifere.Chien;

public class Client {

	private static int port = 9999;

	/**
	 * @param args
	 *            le premier paramètre est l'adresse ip du serveur, s'il est
	 *            omis c'est l'adresse de loopback qui est utilisée.
	 */
	public static void main(String[] args) {
		Socket s = null;
		ObjectOutputStream oos = null;
		try {
			if (args.length == 1)
				s = new Socket(args[0], port);
			else
				s = new Socket((String) null, port);
			System.out.println("Socket du client = " + s);

			oos = new ObjectOutputStream(new BufferedOutputStream(
					s.getOutputStream()));

			Chien chien = new Chien("Médor", Animal.Sexe.FEMELLE, 9);
			Personne personne = new Personne("Pierre", "Durand");
			personne.setMonChien(chien);

			System.out.println("Envoyé par le client : " + personne);
			oos.writeObject(personne);

		} catch (java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				s.close();
			} catch (IOException e) {
			}
		}

	}
}
