module com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser to javafx.fxml;
    exports com.sofia.uni.ai.algorithmvisualiser.algorithmvisualiser;
}