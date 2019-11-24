package ademianiuk.tunesplayer.media;

import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.beans.binding.Bindings;

public class TotalTrackTimeIndicator extends MediaPlayerChangeListener {
    
    private Text text;

    public TotalTrackTimeIndicator(Text text) {
        this.text = text;
    }
    
    @Override
    protected void addListener(MediaPlayer player) {
        this.text.textProperty().bind(
            Bindings.createStringBinding(() -> {
            TrackTimeFormatCreator timeFormatCreator = new TrackTimeFormatCreator(player.getStopTime());
            return timeFormatCreator.create();
        }, player.totalDurationProperty()));
    }

};
