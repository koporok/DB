module com.example.demo23 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.demo23 to javafx.fxml;
    exports com.example.demo23;
}