module ca.georgiancollege.comp1011summer2024tuesdays {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;

    opens ca.georgiancollege.comp1011summer2024tuesdays to javafx.fxml, com.google.gson;
    exports ca.georgiancollege.comp1011summer2024tuesdays;
}