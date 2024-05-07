module ca.georgiancollege.comp1011summer2024tuesdays {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1011summer2024tuesdays to javafx.fxml;
    exports ca.georgiancollege.comp1011summer2024tuesdays;
}