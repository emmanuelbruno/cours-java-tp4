package fr.univ_tln.bruno.tp.tp4.clientserveur;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Class Serveur. Cette classe illustre la création simple d'un serveur TCP.
 * Cette classe écoute sur une socket des objets serialisés qu'elle affiche
 * ensuite.
 */
public class Serveur {

	/** The port. */
	private static int port = 9999;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		ServerSocket s;
		ObjectInputStream ois = null;
		Socket soc = null;
		try {
			s = new ServerSocket(port);
			System.out.println("Serveur attend une connexion sur la socket :"
					+ s);
			soc = s.accept();
			System.out.println("Serveur a reçu une connexion");
			ois = new ObjectInputStream(new BufferedInputStream(
					soc.getInputStream()));

			while (true)
				System.out.println("Lu par le serveur : " + ois.readObject());

		} catch (java.io.EOFException e) {
			System.err.println("Le client a fermé la connexion");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				soc.close();
				System.err.println("Serveur arrêté");
			} catch (IOException e) {
			}
		}
	}

}
