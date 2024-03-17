module com.example.csc325_m5_lab {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.csc325_m5_lab to javafx.fxml;
    exports com.example.csc325_m5_lab;
}