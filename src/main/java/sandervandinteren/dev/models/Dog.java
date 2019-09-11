package sandervandinteren.dev.models;

public class Dog extends Animal implements Sellable {
    private int price;

    public Dog(String name, AnimalGender gender) {
        super(name, gender);
    }

    public int getPrice() {
        return price;
    }
}
