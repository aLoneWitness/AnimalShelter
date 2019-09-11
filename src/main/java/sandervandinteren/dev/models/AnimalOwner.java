package sandervandinteren.dev.models;

public class AnimalOwner {
    private String name;

    public AnimalOwner(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
