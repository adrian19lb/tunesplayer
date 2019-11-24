package ademianiuk.tunesplayer.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DirectoryLoaderTest {

	private File directory;
	private Path pathToFileOne;
	private Path pathToFileTwo;
	
	@BeforeEach
	public void setUp() throws URISyntaxException {
		directory = new File( getClass().getResource("TestFolder").toURI() );
		pathToFileOne = Paths.get( getClass().getResource("TestFolder/TestTextFileOne.txt").toURI() );
		pathToFileTwo = Paths.get( getClass().getResource("TestFolder/TestTextFileTwo.txt").toURI() );
	}
	
	@Test
	void loadFromDirectoryTest() throws URISyntaxException {
		DirectoryLoader< LinkedListContainer<Path> > loader = new DirectoryLoader<>( LinkedListContainer::new );
		Container<Path> pathHolder = loader.load( directory.toPath() );
		
		assertEquals( pathToFileOne, pathHolder.get(0) );
		assertEquals( pathToFileTwo, pathHolder.get(1) );
	}

}
