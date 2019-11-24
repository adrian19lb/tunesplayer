package ademianiuk.tunesplayer.media;

import ademianiuk.tunesplayer.util.DoublePropertySupplier;
import javafx.beans.property.DoubleProperty;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SliderValuePropertyListener extends MediaPlayerChangeListener {

	private DoublePropertySupplier supplier;

    public SliderValuePropertyListener(DoublePropertySupplier supplier) {
        this.supplier = supplier; 
    }
    
    @Override
    protected void addListener(MediaPlayer player) {
        DoubleProperty doubleProperty = supplier.getAsDoubleProperty();
        doubleProperty.addListener((observable, oldValue, newValue) -> {
            player.seek(Duration.seconds(newValue.doubleValue())); 
        });
    }

};
