package sandervandinteren.dev.models;

import sandervandinteren.dev.models.AnimalGender;

public abstract class Animal {
    private String name;
    private AnimalGender gender;
    private AnimalOwner owner;

    public Animal(String name, AnimalGender gender){
        this.name = name;
        this.gender = gender;
    }

    public boolean assignTo(AnimalOwner owner){
        if(this.owner != null){
            return false;
        }

        this.owner = owner;
        return true;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.gender;
    }
}
