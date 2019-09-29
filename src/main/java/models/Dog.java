package models;

import java.io.Serializable;

public class Dog extends Animal implements Sellable, Serializable {
    private int currentPrice;

    public Dog(String name, AnimalGender gender, int totalDogsProduced) {
        super(name, gender);

        currentPrice = 500 - 50 * totalDogsProduced;
        if(currentPrice < 50){
            currentPrice = 50;
        }
    }

    public boolean sellTo(AnimalOwner owner) {
        if(super.owner != null){
            return false;
        }

        super.owner = owner;
        return true;
    }

    public int getPrice() {
        return currentPrice;
    }
}
