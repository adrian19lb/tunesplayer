package ademianiuk.tunesplayer.media;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import ademianiuk.tunesplayer.collection.Container;
import ademianiuk.tunesplayer.collection.LinkedListContainer;
import javafx.stage.Stage;

class TrackPlayerTest extends ApplicationTest {
	
	Path absoluteFirstTrackPath;
	Path absoluteSecondTrackPath;
	Path absoluteThirdTrackPath;
	Container<Path> trackPaths;
	
	/* (non-Javadoc)
	 * @see org.testfx.framework.junit5.ApplicationTest#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws URISyntaxException {
		absoluteFirstTrackPath = Paths.get( getClass().getResource("TestTrackOne.wav").toURI());
		absoluteSecondTrackPath = Paths.get(getClass().getResource("TestTrackTwo.wav").toURI());
		absoluteThirdTrackPath = Paths.get(getClass().getResource("TestTrackThree.wav").toURI());
	}
	
	@BeforeEach
	public void setUp() throws Exception {
		trackPaths = new LinkedListContainer<>();
		trackPaths.add(absoluteFirstTrackPath);
		trackPaths.add(absoluteSecondTrackPath);
		trackPaths.add(absoluteThirdTrackPath);
	}
	
	@Test
	public void playTest() {
		//TrackPlayer player = new TrackPlayer(trackPaths);
		//player.play();
	}
	
	@Test
	public void playNextTest() {
		//TrackPlayer player = new TrackPlayer(trackPaths);
		//player.nextTrack();
		//player.play();
	}
	
	@Test
	public void playPreviousTest() {
		//TrackPlayer player = new TrackPlayer(trackPaths);
		//player.previousTrack();
		//player.play();
	}
	

}
