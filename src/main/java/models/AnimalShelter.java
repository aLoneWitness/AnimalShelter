package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnimalShelter implements Serializable {
    private List<Animal> animals;

    public AnimalShelter() {
        this.animals = new ArrayList<Animal>();
    }

    public ObservableList<Animal> getAnimals() {
        return FXCollections.observableArrayList(animals);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void removeAnimal(Animal animal) { this.animals.remove(animal); }
}
