package ademianiuk.tunesplayer.media;

import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.beans.binding.Bindings;

public class TrackTimeIndicator extends MediaPlayerChangeListener {
    
    private Text text;

    public TrackTimeIndicator(Text text) {
        this.text = text;
    }
    
    @Override
    protected void addListener(MediaPlayer player) {
        text.textProperty().bind(
            Bindings.createStringBinding(() -> {
            TrackTimeFormatCreator timeFormatCreator = new TrackTimeFormatCreator(player.getCurrentTime());
            return timeFormatCreator.create();
        }, player.currentTimeProperty()));

    }

};
