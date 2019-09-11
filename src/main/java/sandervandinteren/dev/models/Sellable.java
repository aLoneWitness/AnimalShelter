package sandervandinteren.dev.models;

public interface Sellable {
    boolean assignTo(AnimalOwner owner);
    int getPrice();
}
