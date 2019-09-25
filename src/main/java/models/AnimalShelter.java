package models;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter implements Observable {
    private List<Animal> animals;

    public AnimalShelter(){
        animals = new ArrayList<Animal>();
    }

    public void Update(Object object) {

    }
}
