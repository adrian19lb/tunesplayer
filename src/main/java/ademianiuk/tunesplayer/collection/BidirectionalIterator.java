package ademianiuk.tunesplayer.collection;

import java.util.Iterator;

public interface BidirectionalIterator<E> extends Iterator<E> {

	E next();

	E previous();

	E first();

	E last();

	E current();

	int index();
	
	int count();

}
