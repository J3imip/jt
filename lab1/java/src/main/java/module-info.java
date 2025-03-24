module jeimip.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens jeimip.lab1 to javafx.fxml;
    exports jeimip.lab1;
}