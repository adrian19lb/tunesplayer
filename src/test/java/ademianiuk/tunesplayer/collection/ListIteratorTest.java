package ademianiuk.tunesplayer.collection;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.easymock.EasyMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListIteratorTest {
	
//	private LinkedListContainer<Path> trackPath;
	
	public Container<Path> mockContainer;
	
	private Path trackPathOne;
	private Path trackPathTwo;

	public BidirectionalArrayIterator<Path> testedIterator;
	
	@BeforeEach
	public void setUp() {
		trackPathOne = Paths.get( getClass().getResource("TestFolder/TestTextFileOne.txt").toString() );
		trackPathTwo = Paths.get( getClass().getResource("TestFolder/TestTextFileTwo.txt").toString() );
		mockContainer = EasyMock.mock(Container.class);
		
		expect(mockContainer.get(0))
			.andStubReturn(trackPathOne);
		expect( mockContainer.size() )
			.andReturn(2);
	}
	
	@AfterEach
	public void tearDown() {
		EasyMock.reset(mockContainer);
	}
	
	@Test
	public void firstTest() {
		expect( mockContainer.get(0) )
			.andStubReturn(trackPathOne);
		replay(mockContainer);
		
		testedIterator = new BidirectionalArrayIterator<>(mockContainer);
		
		assertEquals(trackPathOne, testedIterator.first());
		verify(mockContainer);
	}
	
	@Test
	public void lastTest() {
		expect( mockContainer.get(1))
			.andStubReturn(trackPathTwo);
		replay(mockContainer);
		
		testedIterator = new BidirectionalArrayIterator<>(mockContainer);
		
		assertEquals(trackPathTwo, testedIterator.last());
		verify(mockContainer);
	}

	@Test
	public void nextTest() {
		expect(mockContainer.get(1))
			.andStubReturn(trackPathTwo);
		expect(mockContainer.get(2))
			.andThrow(new IndexOutOfBoundsException("Out of range"))
			.andStubReturn(trackPathOne);
		replay(mockContainer);
		
		testedIterator = new BidirectionalArrayIterator<>(mockContainer);
		testedIterator.last();
		
		assertEquals(trackPathOne, testedIterator.next());
		assertEquals(trackPathTwo, testedIterator.next());
		verify(mockContainer);
	}

	@Test
	public void previousTest() {
		expect(mockContainer.get(-1))
			.andThrow(new IndexOutOfBoundsException("Out of range"))
			.andStubReturn(trackPathTwo);
		expect(mockContainer.get(1))
			.andStubReturn(trackPathTwo);
		replay(mockContainer);
		
		testedIterator = new BidirectionalArrayIterator<>(mockContainer);
		testedIterator.first();
		
		assertEquals(trackPathTwo, testedIterator.previous());
		assertEquals(trackPathOne, testedIterator.previous());
		verify(mockContainer);
	}
	
}
