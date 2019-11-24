package ademianiuk.tunesplayer.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import ademianiuk.tunesplayer.collection.Container;
import ademianiuk.tunesplayer.media.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;

public class MediaPlayerController {
    
    private TrackPlayer player;

    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;
    
    private ChangeBean<MediaPlayer> changedMediaPlayerHandler;  

    @FXML
    private Text start;
            
    @FXML
    private Text end;
    
    @FXML
    private Button play;

    @FXML
    private ColloredSlider duration;

    @FXML
    private ColloredSlider volume;

    @FXML
    void initialize() throws IOException {
        initializeListeners();
    }

    void initializeListeners() {
        changedMediaPlayerHandler = new ChangeBean<>("mediaPlayer");
        changedMediaPlayerHandler.add(new TotalDurationListener((value) -> {duration.setMax(value);} ));
        changedMediaPlayerHandler.add(new MediaTimePropertyListener((value) -> {duration.setValue(value); }));
        changedMediaPlayerHandler.add(new SliderValuePropertyListener(() -> { return duration.valueProperty(); }));
        changedMediaPlayerHandler.add(new VolumeSliderBinder(() -> { return volume.valueProperty(); }));
        changedMediaPlayerHandler.add(new TrackTimeIndicator(start));
        changedMediaPlayerHandler.add(new TotalTrackTimeIndicator(end));
        changedMediaPlayerHandler.add(new ButtonPlayPauseBackgroundUpdater(play, 
                    Paths.get(MediaPlayerController.class.getResource("button/play.png").toString()),
                    Paths.get(MediaPlayerController.class.getResource("button/pause.png").toString())));
        changedMediaPlayerHandler.add(new MediaPlayerEndOfMediaUpdater( () -> initMediaPlayer(player.nextMedia()))); //autoplay on end media;
    }

    @FXML
    private void playCurrentMedia(ActionEvent event) throws InvalidTrackPathException {
        event.consume();
        initMediaPlayerIfIsNull();        
        changeMediaPlayerState();
    }

    private void initMediaPlayerIfIsNull() throws InvalidTrackPathException {
        if (mediaPlayer == null) {
            initMediaPlayer(player.currentMedia());
        }
    }

    private void changeMediaPlayerState() {
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
        }else {
            mediaPlayer.play();
        }
    }

    private void playMedia() {
        mediaView.setMediaPlayer(mediaPlayer);
        changedMediaPlayerHandler.set(mediaPlayer);
        mediaPlayer.play();
    }

    @FXML
    private void forwardTrack(ActionEvent event) throws InvalidTrackPathException {
        event.consume();
        initMediaPlayer(player.nextMedia());
    }

    private void initMediaPlayer(Media media) {
        mediaPlayer = new MediaPlayer(media);
        playMedia();
    }

    @FXML
    private void backwardTrack(ActionEvent event) throws InvalidTrackPathException {
        event.consume();
        initMediaPlayer(player.previousMedia());
    }

    public void setTrackList(Container<Path> trackList) {
        try {
            player = new TrackPlayer(trackList); 
        } catch(EmptyTrackListException e){
            e.printStackTrace();
        }
    }
}
