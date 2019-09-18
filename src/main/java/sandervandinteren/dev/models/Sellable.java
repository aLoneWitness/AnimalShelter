package sandervandinteren.dev.models;

public interface Sellable {
    boolean sellTo(AnimalOwner owner);
    int getPrice();
}
