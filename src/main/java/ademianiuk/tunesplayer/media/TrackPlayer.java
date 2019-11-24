package ademianiuk.tunesplayer.media;

import java.nio.file.Path;

import ademianiuk.tunesplayer.collection.BidirectionalIterator;
import ademianiuk.tunesplayer.collection.Container;
import javafx.scene.media.Media;

public class TrackPlayer {

	private BidirectionalIterator<Path> pathIndicator;
	private Container<Path> tracksPathsHolder;
	private MediaTrackPathValidator trackPathValidator;
	
	public TrackPlayer(Container<Path> tracksPaths) throws EmptyTrackListException {
		this.tracksPathsHolder = tracksPaths;
		this.trackPathValidator = new MediaTrackPathValidator();
		tryCreateTrackPathIterator();
		this.pathIndicator = trackPathValidator.validateNext(this.pathIndicator);
	}

	private void tryCreateTrackPathIterator() throws EmptyTrackListException {
		try {
			pathIndicator = tracksPathsHolder.createIterator();
		}catch (IndexOutOfBoundsException e) {
            throw new EmptyTrackListException("empty track list, add some files", e);
		}catch (NullPointerException e) {
            throw new EmptyTrackListException("empty track list, add some files", e);
		}
	}

    public Media currentMedia() throws InvalidTrackPathException {
        try {
            MediaResourceCreator mediaCreator = new MediaResourceCreator();
            return mediaCreator.create(pathIndicator.current());
        } catch(InvalidTrackPathException e){
            throw e;
        } 
    }

	public Media nextMedia() throws InvalidTrackPathException {
		try {
            MediaResourceCreator mediaCreator = new MediaResourceCreator();
            return mediaCreator.create(pathIndicator.next());
		}catch (NullPointerException e) {
            throw new InvalidTrackPathException();
		}catch (InvalidTrackPathException e) {
            throw e;
        }
	}

	public Media previousMedia() throws InvalidTrackPathException {
		try {
            MediaResourceCreator mediaCreator = new MediaResourceCreator();
            return mediaCreator.create(pathIndicator.previous());
		}catch (NullPointerException e) {
            throw new InvalidTrackPathException();
		}catch (InvalidTrackPathException e) {
            throw e;
        }
	}

}
