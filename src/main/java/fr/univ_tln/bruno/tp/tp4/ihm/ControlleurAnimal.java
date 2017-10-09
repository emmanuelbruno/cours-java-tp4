package fr.univ_tln.bruno.tp.tp4.ihm;


import fr.univtln.bruno.coursjava.tp.tp2.animal.Animal;
import fr.univtln.bruno.tp.tp3.AnimalTatoue;

import java.util.Collection;

public class ControlleurAnimal {

    private final VueAnimal vueAnimal;
    private ModeleAnimal modeleAnimal;
    private AnimalTatoue animal;

    public ControlleurAnimal(ModeleAnimal modeleAnimal, VueAnimal vueChien) {
        super();
        this.vueAnimal = vueChien;
        this.modeleAnimal = modeleAnimal;
    }

    public void creerAnimal(String nom, Animal.Sexe sexe) {
            AnimalTatoue animalTatoue = new AnimalTatoue("Chien", nom, Animal.Sexe.MALE);
        modeleAnimal.add(animalTatoue);
        System.out.println("-->" + animalTatoue);
    }

    public Collection<AnimalTatoue> getListeAnimaux() {
        return modeleAnimal.getAnimaux();
    }
}
