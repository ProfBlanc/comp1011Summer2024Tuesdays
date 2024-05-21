package ca.georgiancollege.comp1011summer2024tuesdays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class CameraController {

    @FXML
    private ImageView mainPhoto;

    private ArrayList<Camera> cameraList = new ArrayList<>();
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField color, lens, make, model, sensor;

    @FXML
    private Label error, output;

    private Camera camera = new Camera();

    @FXML
    void clear(){

        make.clear();
        model.clear();
        lens.clear();
        color.clear();
        sensor.clear();
    }
    @FXML
    void onSubmit(ActionEvent event) {
        error.setText("");
        model.getText(); // gets the text inputted by the user in the TextField
        error.getText();
        //error.setText("something");

        /*
Add the code to the Controller
    evaluated each TextField
        determine that each TextField has a length() of at least 1
            if not, send an error message to the error label
            if so, instantiate a new Camera object and pass the values of the TextFields

         */
        try {
//            Camera camera = new Camera(model.getText(), make.getText(),
//                    color.getText(), sensor.getText(), lens.getText());

            camera.setMake(make.getText());
            camera.setModel(model.getText());
            camera.setLens(lens.getText());
            camera.setSensor(sensor.getText());
            camera.setColor(color.getText());

            output.setText(camera.toString());
            clear();
            cameraList.add(camera);
            displayCameras();
            addToComboBox(camera);
        }
        catch (IllegalArgumentException e){

            error.setText(e.getMessage());
        }

    }
    private void displayCameras(){

        for(Camera c : cameraList){
            System.out.println(c);
        }
        System.out.println("-".repeat(20));
    }
    public void initialize(){

        //runs right before the Stage is shown

        output.setText("");
        //output.setWrapText(true);
        error.setText("");
        //addToComboBox();
    }

    @FXML
    private void addToComboBox(Camera c){

        combo.getItems().add(c.getMake() +": " + c.getModel());

    }

    @FXML
    void onChange(ActionEvent event) {
        System.out.println("Changed!");

        int index = combo.getSelectionModel().getSelectedIndex();

        output.setText(cameraList.get(index).toString());
    }
    @FXML
    void onArrowClick(ActionEvent event){
        String text = ( (Button) event.getSource()).getText();
        System.out.println(text);
mainPhoto.setImage(new Image(String.valueOf(getClass().getResource("images/photo2.jpg"))));

    }
}
