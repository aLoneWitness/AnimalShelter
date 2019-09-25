package models;

public class Dog extends Animal implements Sellable {
    static int currentPrice = 500;

    public Dog(String name, AnimalGender gender) {
        super(name, gender);
    }

    public static void resetDogPrice(){
        currentPrice = 500;
    }

    public boolean sellTo(AnimalOwner owner) {
        if(super.owner != null){
            return false;
        }

        super.owner = owner;
        currentPrice = currentPrice - 50;
        if(currentPrice < 50){
            currentPrice = 50;
        }
        return true;
    }

    public int getPrice() {
        return currentPrice;
    }
}
