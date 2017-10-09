package fr.univ_tln.bruno.tp.tp4.ihm;

import fr.univtln.bruno.tp.tp3.AnimalTatoue;
import fr.univtln.bruno.tp.tp3.MapAnimalTatoue;
import fr.univtln.bruno.tp.tp3.Tatouage;

import java.util.Collection;
import java.util.Observable;

public class ModeleAnimal extends Observable {
    private MapAnimalTatoue mapAnimalTatoue = new MapAnimalTatoue();

    public void add(AnimalTatoue animalTatoue) {
        mapAnimalTatoue.put(animalTatoue);
        System.out.println(animalTatoue+ " added");
        setChanged();
        notifyObservers();
    }

    public void remove(Tatouage tatouage) {
        mapAnimalTatoue.remove(tatouage);
        setChanged();
        notify();
    }

    public Collection<AnimalTatoue> getAnimaux() {
        return mapAnimalTatoue.values();
    }
}
