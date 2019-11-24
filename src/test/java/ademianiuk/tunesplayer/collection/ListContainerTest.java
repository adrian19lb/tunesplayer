package ademianiuk.tunesplayer.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ademianiuk.tunesplayer.collection.LinkedListContainer;

public class ListContainerTest {
	
	Path filePath;
	LinkedListContainer<Path> testedTrackPaths;
	
	@BeforeEach
	void init() {
		filePath = Paths.get( getClass().getResource("TestFolder/TestTextFileOne.txt").toString() );
		testedTrackPaths = new LinkedListContainer<Path>();
	}
	
	@Test
	void add() {
		testedTrackPaths.add(filePath);
		
		assertEquals(filePath, testedTrackPaths.get(0));
	}
	
	@Test
	void erase() {
		testedTrackPaths.add(filePath);
		testedTrackPaths.erase(filePath);
		
		assertEquals(0, testedTrackPaths.size());
	}
	
	@Test
	void clear() {
		testedTrackPaths.add(filePath);
		testedTrackPaths.clear();
		
		assertEquals(0, testedTrackPaths.size());
	}

}
