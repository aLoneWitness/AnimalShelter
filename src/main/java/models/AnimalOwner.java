package models;

import java.io.Serializable;

public class AnimalOwner implements Serializable {
    private String name;

    public AnimalOwner(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
