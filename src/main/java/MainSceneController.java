import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import models.Animal;
import models.AnimalGender;
import models.AnimalShelter;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    private AnimalShelter shelter;

    @FXML
    public ChoiceBox<AnimalGender> genderChoiceBox;

    @FXML
    public ChoiceBox<String> typeChoiceBox;

    private ObservableList<AnimalGender> genderChoices = FXCollections.observableArrayList();


    @FXML
    public void addButtonClicked(Event e){

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        shelter = new AnimalShelter();

        for (AnimalGender gender : AnimalGender.values()) {
            genderChoices.add(gender);
        }

        genderChoiceBox.setItems(genderChoices);
    }
}
