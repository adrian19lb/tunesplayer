package ademianiuk.tunesplayer.media;

public class InvalidTrackPathException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTrackPathException() {

	}
	
	public InvalidTrackPathException(String message) {
		super(message);
	}
	
	public InvalidTrackPathException(Throwable cause) {
		super(cause);
	}
	
	public InvalidTrackPathException(String message, Throwable cause) {
		super(message, cause);
	}

}
