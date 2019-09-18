import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        boolean result = cat.sellTo(owner);

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
        cat.sellTo(ownerOne);
        boolean result = cat.sellTo(ownerTwo);

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
        Dog.resetDogPrice();
        for(int i = 0; i < 2; ++i){
            Dog dog = new Dog("DogName", AnimalGender.Female);
            dog.sellTo(new AnimalOwner("OwnerName"));
        }
        Dog dog2 = new Dog("DogName", AnimalGender.Female);

        // Act
        int price = dog2.getPrice();

        // Assert
        Assertions.assertEquals(400, price);
    }

    @Test
    void testDogSaleAmountOutsideBounds(){
        // Arrange
        Dog.resetDogPrice();
        for(int i = 0; i < 50; ++i){
            Dog dog = new Dog("DogName", AnimalGender.Female);
            dog.sellTo(new AnimalOwner("OwnerName"));
        }
        Dog dog = new Dog("DogName", AnimalGender.Female);

        // Act
        int price = dog.getPrice();

        // Assert
        Assertions.assertEquals(50, price);
    }

}
