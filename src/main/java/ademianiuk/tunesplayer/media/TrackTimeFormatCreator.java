package ademianiuk.tunesplayer.media;

import javafx.util.Duration;

public class TrackTimeFormatCreator {
    
    private final int HOURS_MINUTES;

    private final int HOURS_SECONDS;

    public Duration duration;

    public TrackTimeFormatCreator(Duration duration) {
        this.HOURS_MINUTES = 60;
        this.HOURS_SECONDS = 3600;
        this.duration = duration;
    } 

    public String create() {
        return String.format("%01d:%02d",
        (int) duration.toMinutes() % HOURS_MINUTES,
        (int) duration.toSeconds() % HOURS_MINUTES);
    }
};
