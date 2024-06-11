package ca.georgiancollege.comp1011summer2024tuesdays;

import javafx.fxml.FXML;

public class SB2Controller {

    private StringAndStringBuilderModel model;

    public void setModel(StringAndStringBuilderModel model){
        this.model = model;
    }

    @FXML
    private void initialize(){


        System.out.println(model.getDataType());
        System.out.println(model.getContent());
    }
}
