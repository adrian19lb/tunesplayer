package ademianiuk.tunesplayer.media;

import java.nio.file.Path;

import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;

public class ButtonPlayPauseBackgroundUpdater extends MediaPlayerChangeListener {
    
    private final Path pauseButtonBackground;

    private final Path playButtonBackground;

    private Button button;
   
    private MediaPlayer player;

    public ButtonPlayPauseBackgroundUpdater(Button button, Path playBackground, Path pauseBackground) {
        this.pauseButtonBackground = pauseBackground; 
        this.playButtonBackground = playBackground;
        this.button = button;
    }

    @Override
    protected void addListener(MediaPlayer player) {
        this.player = player;
        setOnPaused();
        setOnPlaying(); 
    }
    
    private void setOnPlaying() {
        player.setOnPlaying(()-> {
            setButtonStyle();
        });
    }

    private void setOnPaused() {
        player.setOnPaused(()-> {
            setButtonStyle();
        });
    }

    private void setButtonStyle() {
        String buttonFilenameString = getButtonFilenameString();
        String style = String.format("-fx-background-image: url('%s');", buttonFilenameString);
        button.setStyle(style);
    }
    
    private String getButtonFilenameString() {
        if (isMediaPlayerPlaying()) {
            return playButtonBackground.toString();
        }else {
            return pauseButtonBackground.toString();
        }
    }

    private boolean isMediaPlayerPlaying() {
        return player.getStatus() == MediaPlayer.Status.PLAYING;
    }

};
