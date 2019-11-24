package ademianiuk.tunesplayer.media;

import java.nio.file.Path;

import javafx.scene.media.Media;
import javafx.scene.media.MediaException;

public class MediaResourceCreator {
	
	public MediaResourceCreator() {
		
	}
	
	public Media create(Path filePath) throws InvalidTrackPathException {
		try {
			return new Media( filePath.toUri().toString() );
		}catch (NullPointerException e) {
			throw new InvalidTrackPathException(e.getMessage(), e.getCause());
		}catch (IllegalArgumentException e) {
			throw new InvalidTrackPathException(e.getMessage(), e.getCause());
		}catch (UnsupportedOperationException e) {
			throw new InvalidTrackPathException(e.getMessage(), e.getCause());
		}catch (MediaException e) {
			throw new InvalidTrackPathException(e.getMessage(), e.getCause());
		}
	}

}
