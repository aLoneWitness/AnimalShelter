package factory;

import models.Animal;
import models.AnimalGender;
import models.Cat;
import models.Dog;

public class AnimalFactory {
    static int totalDogsProduced = 0;

    public static Animal createAnimal(String animalType, String name, AnimalGender gender, String badHabits){
        if(animalType.equalsIgnoreCase("DOG")){
            Dog dog = new Dog(name, gender, totalDogsProduced);
            totalDogsProduced = totalDogsProduced + 1;
            return dog;
        }
        else if(animalType.equalsIgnoreCase("CAT")){
            return new Cat(name, gender, badHabits);
        }
        else {
            return null;
        }
    }
}
