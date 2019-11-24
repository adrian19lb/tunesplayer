package ademianiuk.tunesplayer.media;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Optional;

import javafx.scene.media.MediaPlayer;

public abstract class MediaPlayerChangeListener implements PropertyChangeListener {
        
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        MediaPlayer oldMediaPlayer = (MediaPlayer) event.getOldValue();
        Optional<MediaPlayer> optional = Optional.ofNullable(oldMediaPlayer);
        optional.ifPresent(player -> player.stop());
        MediaPlayer currentMediaPlayer = (MediaPlayer) event.getNewValue();
        addListener(currentMediaPlayer);
    }

    protected abstract void addListener(MediaPlayer player);

};
