package ademianiuk.tunesplayer.media;

public class EmptyTrackListException extends RuntimeException {
	
    private static final long serialVersionUID = 2L;
    
    public EmptyTrackListException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

