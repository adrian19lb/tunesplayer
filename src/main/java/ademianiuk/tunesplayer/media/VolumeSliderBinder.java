package ademianiuk.tunesplayer.media;

import javafx.scene.media.MediaPlayer;
import ademianiuk.tunesplayer.util.DoublePropertySupplier;
import javafx.beans.binding.Bindings;

public class VolumeSliderBinder extends MediaPlayerChangeListener {
    
    private DoublePropertySupplier supplier;

    public VolumeSliderBinder(DoublePropertySupplier supplier) {
        this.supplier = supplier; 
    }
    
    @Override
    protected void addListener(MediaPlayer player) {
        player.volumeProperty().bind(
            Bindings.createDoubleBinding(() -> {
                return supplier.getAsDoubleProperty().getValue();
            }, supplier.getAsDoubleProperty()));
    }

};
