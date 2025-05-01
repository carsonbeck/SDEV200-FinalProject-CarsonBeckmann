module CurrencyConverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    opens org.example.sdev200finalprojectcarsonbeckmann to javafx.fxml; // Replace with your package name
}

/*module org.example.sdev200finalprojectcarsonbeckmann {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens org.example.sdev200finalprojectcarsonbeckmann to javafx.fxml;
    exports org.example.sdev200finalprojectcarsonbeckmann;
}*/