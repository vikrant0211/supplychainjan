module com.example.supplychainjan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainjan to javafx.fxml;
    exports com.example.supplychainjan;
}