package ademianiuk.tunesplayer.media;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import javafx.scene.media.MediaException;

class MediaPlayerResourceCreatorTest {

	@Test
	void createMediaTest() {
		MediaResourceCreator mediaResourceCreator = new MediaResourceCreator();
		
		assertThrows(InvalidTrackPathException.class, () -> {
			mediaResourceCreator.create(Paths.get(""));
		});

		assertThrows(InvalidTrackPathException.class, () -> {
			Path nullPath = null;
			mediaResourceCreator.create(nullPath);
		});
	}

}
