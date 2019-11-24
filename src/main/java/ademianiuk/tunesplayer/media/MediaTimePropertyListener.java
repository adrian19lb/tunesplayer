package ademianiuk.tunesplayer.media;

import java.util.function.DoubleConsumer;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MediaTimePropertyListener extends MediaPlayerChangeListener {

	private DoubleConsumer consumer;

    public MediaTimePropertyListener(DoubleConsumer consumer) {
        this.consumer = consumer;
    }
    
    @Override
    protected void addListener(MediaPlayer player) {
        ReadOnlyObjectProperty<Duration> timeProperty = player.currentTimeProperty();
        timeProperty.addListener((observable, oldValue, newValue) -> {
            consumer.accept(newValue.toSeconds());
        });
    }

};
