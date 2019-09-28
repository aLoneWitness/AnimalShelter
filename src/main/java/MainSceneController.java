import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.*;
import storage.AnimalRepository;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    private AnimalShelter shelter;
    private AnimalRepository animalRepository;

    @FXML
    ListView<Animal> animalListView;

    @FXML
    public TextField nameInput;

    @FXML
    public ChoiceBox<AnimalGender> genderChoiceBox;
    private ObservableList<AnimalGender> genderChoices = FXCollections.observableArrayList();

    @FXML
    public ChoiceBox<String> typeChoiceBox;
    private ObservableList<String> typeChoices = FXCollections.observableArrayList();

    @FXML
    public TextArea badHabitsArea;

    @FXML
    public void addButtonClicked(Event e) throws IOException {
        if(typeChoiceBox.getValue().equals("Dog")){
            this.shelter.addAnimal(new Dog(nameInput.getText(), genderChoiceBox.getValue()));
        }
        else if (typeChoiceBox.getValue().equals("Cat")){
            this.shelter.addAnimal(new Cat(nameInput.getText(), genderChoiceBox.getValue(), badHabitsArea.getText()));
        }

        animalListView.setItems(this.shelter.getAnimals());

        animalRepository.saveAnimalShelter(this.shelter);
    }

    @FXML
    public void removeButtonClicked(Event e) throws IOException {
        for (Animal animal: animalListView.getSelectionModel().getSelectedItems()) {
            this.shelter.removeAnimal(animal);
        }

        animalListView.setItems(this.shelter.getAnimals());

        animalRepository.saveAnimalShelter(this.shelter);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.shelter = new AnimalShelter();
        this.animalRepository = new AnimalRepository();

        try {
            this.shelter = this.animalRepository.getSavedAnimalShelter();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        animalListView.setItems(this.shelter.getAnimals());

        Collections.addAll(genderChoices, AnimalGender.values());
        genderChoiceBox.setItems(genderChoices);

        typeChoices.add("Dog");
        typeChoices.add("Cat");
        typeChoiceBox.setItems(typeChoices);
    }
}
