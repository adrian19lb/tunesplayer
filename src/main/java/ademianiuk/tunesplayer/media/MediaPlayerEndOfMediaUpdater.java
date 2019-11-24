package ademianiuk.tunesplayer.media;

import javafx.scene.media.MediaPlayer;

public class MediaPlayerEndOfMediaUpdater extends MediaPlayerChangeListener {
    
    public interface Executor {
        
        public void execute() throws InvalidTrackPathException;
    };

    private Executor executor;

    public MediaPlayerEndOfMediaUpdater(Executor executor) {
        this.executor = executor; 
    }

	@Override
	protected void addListener(MediaPlayer player) {
		player.setOnEndOfMedia(() -> {
            try {
                executor.execute(); 
            } catch(InvalidTrackPathException e){
                System.out.println("forwardEmpty");
            }
        });
	}
}
