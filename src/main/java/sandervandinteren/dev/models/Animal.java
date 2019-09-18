package sandervandinteren.dev.models;

public abstract class Animal {
    private String name;
    private AnimalGender gender;
    protected AnimalOwner owner;

    public Animal(String name, AnimalGender gender){
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.gender;
    }
}
