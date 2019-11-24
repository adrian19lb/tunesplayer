package ademianiuk.tunesplayer.media;

import java.nio.file.Path;

import ademianiuk.tunesplayer.collection.BidirectionalIterator;
import ademianiuk.tunesplayer.collection.IntegerCounter;

public class MediaTrackPathValidator {
	
	private IntegerCounter wrongPathsAmount;
	private MediaResourceCreator creator;
	
	private interface Traversable {
		public void process();
	}
	
	public MediaTrackPathValidator() {
		creator = new MediaResourceCreator();
	}
	
	public BidirectionalIterator<Path> validateNext(BidirectionalIterator<Path> resourceIterator) {
		wrongPathsAmount = new IntegerCounter();
		tryTraverse(resourceIterator, ()-> { resourceIterator.next(); });

		return resourceIterator;
		
	}

	private void tryTraverse(BidirectionalIterator<Path> resourceIterator, Traversable direction) {
		Integer resourceAmount = resourceIterator.count();
		while ( !wrongPathsAmount.isEqual(resourceAmount) ) {
			try {
				creator.create( resourceIterator.current() );
				break;
			}catch (InvalidTrackPathException e) {
				direction.process();
				wrongPathsAmount.increment();
			}
		}
	}

	public BidirectionalIterator<Path> validatePrevious(BidirectionalIterator<Path> resourceIterator) {
		wrongPathsAmount = new IntegerCounter();
		tryTraverse(resourceIterator, ()-> { resourceIterator.previous(); });

		return resourceIterator;

	}
}
