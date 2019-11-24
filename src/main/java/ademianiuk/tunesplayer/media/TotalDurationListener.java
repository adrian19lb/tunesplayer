package ademianiuk.tunesplayer.media;

import java.util.function.DoubleConsumer;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class TotalDurationListener extends MediaPlayerChangeListener  {
    
    private final int SECONDS_TO_HOURS;

	private DoubleConsumer consumer;

    public TotalDurationListener(DoubleConsumer consumer) {
        this.SECONDS_TO_HOURS = 3600;
        this.consumer = consumer; 
    }
    
    @Override
    protected void addListener(MediaPlayer player) {
        ReadOnlyObjectProperty<Duration> durationProperty = player.totalDurationProperty();
        durationProperty.addListener((observable, oldValue, newValue) -> {
            Duration duration = player.getTotalDuration();
            consumer.accept(duration.toSeconds() % SECONDS_TO_HOURS);
        });
    }

};
