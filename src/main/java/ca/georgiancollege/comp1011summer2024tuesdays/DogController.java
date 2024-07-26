package ca.georgiancollege.comp1011summer2024tuesdays;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class DogController {

    @FXML
    private ImageView picture;

    @FXML
    private TextField status;


    @FXML
    public void initialize() throws Exception{

        DogAPIRequest request = new DogAPIRequest();
        Dog dog = request.getData("https://dog.ceo/api/breeds/image/random");

        status.setText(dog.getStatus());

        picture.setImage(
                new Image(
                        dog.getMessage()
                )
        );
    }
}
