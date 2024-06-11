package ca.georgiancollege.comp1011summer2024tuesdays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CameraController {


    EventHandler<MouseEvent> mouseEventEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Random Mouse Event");
        }
    };

    @FXML
    Button btn, btnEdit, btnDelete;

    @FXML
    private ImageView mainPhoto, rightPhoto;

    private ArrayList<Camera> cameraList = new ArrayList<>();

    private ArrayList<String> photoList = new ArrayList<>();
    private int photoListIndex;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TextField color, lens, make, model, sensor;

    @FXML
    private Label error, output;


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
            Camera camera = new Camera(model.getText(), make.getText(),
                    color.getText(), sensor.getText(), lens.getText());

//            camera.setMake(make.getText());
//            camera.setModel(model.getText());
//            camera.setLens(lens.getText());
//            camera.setSensor(sensor.getText());
//            camera.setColor(color.getText());
            camera.setPhoto(photoList.get(photoListIndex));
            output.setText(camera.toString());

            rightPhoto.setImage(
                    new Image(
                            String.valueOf(getClass().getResource(camera.getPhoto()))
                    )
            );

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


        btn.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent e) {
                System.out.println("Clicked the context menu");
            }
        });

        btn.setOnMouseExited(e -> System.out.println("Exited mouse"));

        btn.setOnMouseEntered( (e) -> {System.out.println("Entered mouse");   }    );

        btn.setOnMouseMoved(mouseEventEventHandler);


        String path = getClass().getResource("images").getPath();
       // String path1 = "./src/main/resources/images";

        System.out.println(path);
        try {
            Path p = Path.of(getClass().getResource("images").toURI());
            //Path p = Path.of(path1);
            System.out.println(p);

            System.out.println(p.toFile().exists());


//            for(File f : p.toFile().listFiles()){
//                System.out.println(f.getName());
//            }



            for(String filePath : p.toFile().list()){
                //photoList.add(p.resolve(filePath).toString());

                if(filePath.contains("photo"))
                   photoList.add("images/"+filePath);
   //             System.out.println(p.resolve(filePath));
            }


            btnEdit.setText("");
            btnEdit.setGraphic(
                    new ImageView(
                            new Image(String.valueOf(getClass().getResource("images/edit.png")))
                    )
            );

            btnEdit.setOnAction(event -> {

                int index = combo.getSelectionModel().getSelectedIndex();
                //known loophole

                Camera selected = cameraList.get(index);

                model.setText(selected.getModel());
                make.setText(selected.getMake());
                lens.setText(selected.getLens());
                sensor.setText(selected.getSensor());
                color.setText(selected.getColor());

                mainPhoto.setImage(
                        new Image(
                                String.valueOf(getClass().getResource(selected.getPhoto()))
                        )
                );

            });


        }
        catch (Exception e){
            System.err.println(e);
        }
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
        rightPhoto.setImage(
                new Image(String.valueOf(getClass().getResource(cameraList.get(index).getPhoto())))
        );
    }
    @FXML
    void onArrowClick(ActionEvent event){
        String text = ( (Button) event.getSource()).getText();
        System.out.println(text);
//mainPhoto.setImage(new Image(String.valueOf(getClass().getResource("images/photo2.jpg"))));

photoListIndex = text.equals(">") ? photoListIndex >= photoList.size() -1 ? 0 : photoListIndex + 1
        : photoListIndex <= 0 ? photoList.size() - 1 : photoListIndex - 1;

//mainPhoto.setImage(new Image(photoList.get(photoListIndex)));
        mainPhoto.setImage(new Image(String.valueOf(getClass().getResource(photoList.get(photoListIndex)))));

    }
}
