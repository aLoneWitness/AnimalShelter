package models;

public class Cat extends Animal implements Sellable {
    private String badHabits;

    public Cat(String name, AnimalGender gender, String badHabits){
        super(name, gender);
        this.badHabits = badHabits;
    }

    public boolean sellTo(AnimalOwner owner) {
        if(super.owner != null){
            return false;
        }

        super.owner = owner;
        return true;
    }

    public int getPrice(){
        int price = 350 - this.badHabits.length() * 20;
        return Math.max(price, 35);
    }
}
