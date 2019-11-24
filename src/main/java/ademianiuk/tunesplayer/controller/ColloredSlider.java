package ademianiuk.tunesplayer.controller;

import java.io.IOException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class ColloredSlider extends StackPane {
    
    @FXML
    private Slider duration;

    @FXML
    private Rectangle progressBar;

    public ColloredSlider() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ColloredSliderView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void initialize() {
        progressBar.heightProperty().bind(duration.heightProperty().subtract(7));
        progressBar.widthProperty().bind(duration.widthProperty());

        duration.valueProperty().addListener((observable, oldValue, newValue) -> {
            double percent = (newValue.doubleValue()/duration.getMax()) * 100;
            String style = String.format("-fx-fill: linear-gradient(to right, #2D819D %d%%, %s %d%%);",
            (int) percent, "#969696", (int) percent);
            progressBar.setStyle(style);
        });
    }

    public final void setMin(Double value) {
        this.minProperty().set(value);
    }

    public final Double getMin() {
       return this.minProperty().get();
    }

    public DoubleProperty minProperty() {
        return this.duration.minProperty();
    }
    
    public final void setMax(Double value) {
        this.maxProperty().set(value);
    }

    public final Double getMax() {
       return this.maxProperty().get();
    }

    public DoubleProperty maxProperty() {
        return this.duration.maxProperty();
    }

    public ObjectProperty<Paint> backgroundCollorProperty() {
        return this.progressBar.fillProperty(); 
    }

    public final void setBackgroundCollor(Paint value) {
        this.backgroundCollorProperty().set(value);
    }

    public final Paint getBackgroundCollor() {
        return this.backgroundCollorProperty().get();
    }

    public DoubleProperty arcHeightProperty() {
        return this.progressBar.arcHeightProperty();
    }

    public final void setArcHeight(Double value) {
        this.arcHeightProperty().set(value);
    }

    public final Double getArcHeight() {
        return this.arcHeightProperty().get();
    }
    
    public DoubleProperty arcWidthProperty() {
        return this.progressBar.arcWidthProperty();
    }

    public final void setArcWidth(Double value) {
        this.arcWidthProperty().set(value);
    }

    public final Double getArcWidth() {
        return this.arcWidthProperty().get();
    }

    public DoubleProperty valueProperty() {
        return this.duration.valueProperty(); 
    }

    public final Double getValue() {
        return this.valueProperty().get();
    }

    public final void setValue(Double value) {
        this.valueProperty().set(value);
    }

};
