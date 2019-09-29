import factory.AnimalFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import models.AnimalGender;
import models.AnimalOwner;
import models.Cat;
import models.Dog;

public class MainTest {
    @Test
    public void TestAssignAnimalToUnownedAnimal(){
        // Arrange
        AnimalOwner owner = new AnimalOwner("Mark");
        Cat cat = new Cat("Minoes", AnimalGender.Female, "");

        // Act
        boolean result = cat.sellTo(owner);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void TestAssignAnimalToOwnedAnimal(){
        // Arrange
        AnimalOwner ownerOne = new AnimalOwner("Mark");
        AnimalOwner ownerTwo = new AnimalOwner("David");
        Cat cat = new Cat("Minoes", AnimalGender.Female, "");


        // Act
        cat.sellTo(ownerOne);
        boolean result = cat.sellTo(ownerTwo);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void TestCatSaleOutsideBounds(){
        // Arrange
        Cat cat = new Cat("Minoes", AnimalGender.Female, "IM A BAAAAAAAD GUUUUUUUUUY duh");


        // Act
        int price = cat.getPrice();

        // Assert
        Assertions.assertEquals(35, price);
    }

    @Test
    public void TestDogSaleAmountInsideBounds(){
        // Arrange
        AnimalFactory.totalDogsProduced = 0;
        for(int i = 0; i < 2; ++i){
            Dog dog = (Dog) AnimalFactory.createAnimal("Dog", "DogName", AnimalGender.Female, "naughty");
            dog.sellTo(new AnimalOwner("OwnerName"));
        }
        Dog dog2 = (Dog) AnimalFactory.createAnimal("Dog", "DogName", AnimalGender.Female, "naughty");

        // Act
        int price = dog2.getPrice();

        // Assert
        Assertions.assertEquals(400, price);
    }

    @Test
    public void TestDogSaleAmountOutsideBounds(){
        // Arrange
        AnimalFactory.totalDogsProduced = 0;
        for(int i = 0; i < 50; ++i){
            Dog dog = (Dog) AnimalFactory.createAnimal("Dog", "DogName", AnimalGender.Female, "naughty");
            dog.sellTo(new AnimalOwner("OwnerName"));
        }
        Dog dog = (Dog) AnimalFactory.createAnimal("Dog", "DogName", AnimalGender.Female, "naughty");

        // Act
        int price = dog.getPrice();

        // Assert
        Assertions.assertEquals(50, price);
    }

}
