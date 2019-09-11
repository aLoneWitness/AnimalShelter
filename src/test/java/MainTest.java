import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import sandervandinteren.dev.models.AnimalGender;
import sandervandinteren.dev.models.AnimalOwner;
import sandervandinteren.dev.models.Cat;
import sandervandinteren.dev.models.Dog;

public class MainTest {
    @Test
    void testAssignAnimalToUnownedAnimal(){
        // Arrange
        AnimalOwner owner = new AnimalOwner("Mark");
        Cat cat = new Cat("Minoes", AnimalGender.Female, "");

        // Act
        boolean result = cat.assignTo(owner);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testAssignAnimalToOwnedAnimal(){
        // Arrange
        AnimalOwner ownerOne = new AnimalOwner("Mark");
        AnimalOwner ownerTwo = new AnimalOwner("David");
        Cat cat = new Cat("Minoes", AnimalGender.Female, "");


        // Act
        cat.assignTo(ownerOne);
        boolean result = cat.assignTo(ownerTwo);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    void testCatSaleOutsideBounds(){
        // Arrange
        Cat cat = new Cat("Minoes", AnimalGender.Female, "IM A BAAAAAAAD GUUUUUUUUUY duh");


        // Act
        int price = cat.getPrice();

        // Assert
        Assertions.assertEquals(35, price);
    }

    @Test
    void testDogSaleAmountInsideBounds(){
        // Arrange
        Dog dog1 = new Dog("Minoes", AnimalGender.Female);
        Dog dog2 = new Dog("Minoes", AnimalGender.Female);
        Dog dog3 = new Dog("Minoes", AnimalGender.Female);

        // Act
        int price = dog3.getPrice();

        // Assert
        Assertions.assertEquals(400, price);
    }

    @Test
    void testDogSaleAmountOutsideBounds(){
        // Arrange
        for(int i = 0; i < 50; i++){
            Dog dog = new Dog("ok", AnimalGender.Female);
        }
        Dog dog = new Dog("ok", AnimalGender.Female);

        // Act
        int price = dog.getPrice();

        // Assert
        Assertions.assertEquals(50, price);
    }

}
