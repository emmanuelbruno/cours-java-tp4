/**
 * 
 */
package fr.univ_tln.bruno.tp.tp4;

import fr.univtln.bruno.coursjava.tp.tp2.animal.mammifere.Chien;

import java.io.Serializable;

/**
 * @author bruno
 *
 */
public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private Chien monChien;
	public Chien getMonChien() {
		return monChien;
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", monChien="
				+ monChien + ", Object=" + super.toString() + "]";
	}
	public void setMonChien(Chien monChien) {
		this.monChien = monChien;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
}
