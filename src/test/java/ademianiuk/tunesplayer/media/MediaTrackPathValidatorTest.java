package ademianiuk.tunesplayer.media;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ademianiuk.tunesplayer.collection.BidirectionalIterator;

class MediaTrackPathValidatorTest {

	private Path correctTrackPath;
	private Path wrongTrackPath;
	private Path nullTrackPath;
	private BidirectionalIterator<Path> mockIterator;
	
	@BeforeEach
	public void setUp() throws URISyntaxException {
		correctTrackPath = Paths.get( getClass().getResource("TestTrackOne.wav").toURI());
		wrongTrackPath =  Paths.get("WrongPathToTrack");
		nullTrackPath = null;
		mockIterator = EasyMock.mock(BidirectionalIterator.class);
	}
	
	@Test
	void validateNextTest() {
		expect(mockIterator.count())
			.andReturn(3);
		expect(mockIterator.current())
			.andReturn(wrongTrackPath)
			.andReturn(nullTrackPath)
			.andStubReturn(correctTrackPath);
		expect(mockIterator.next())
			.andReturn(nullTrackPath)
			.andReturn(correctTrackPath);
		replay(mockIterator);
		
		MediaTrackPathValidator trackPathValidator = new MediaTrackPathValidator();
		mockIterator = trackPathValidator.validateNext(mockIterator);
		
		assertEquals(correctTrackPath, mockIterator.current());
		verify(mockIterator);
	}
	
	@Test
	void validatePreviousTest() {
		expect(mockIterator.count())
			.andReturn(3);
		expect(mockIterator.current())
			.andReturn(wrongTrackPath)
			.andReturn(nullTrackPath)
			.andStubReturn(correctTrackPath);
		expect(mockIterator.previous())
			.andReturn(nullTrackPath)
			.andReturn(correctTrackPath);
		replay(mockIterator);
	
		MediaTrackPathValidator trackPathValidator = new MediaTrackPathValidator();
		mockIterator = trackPathValidator.validatePrevious(mockIterator);
	
		assertEquals(correctTrackPath, mockIterator.current());
		verify(mockIterator);
	}

}
