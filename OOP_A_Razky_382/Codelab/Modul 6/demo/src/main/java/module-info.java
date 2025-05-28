module com.modul6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.modul6 to javafx.fxml;
    exports com.modul6;
}
