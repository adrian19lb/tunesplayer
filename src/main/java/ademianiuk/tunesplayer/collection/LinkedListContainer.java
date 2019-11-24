package ademianiuk.tunesplayer.collection;

import java.util.LinkedList;

public class LinkedListContainer<E> implements Container<E> {
	private LinkedList<E> trackPaths;
	
	public LinkedListContainer() {
		super();
		trackPaths = new LinkedList<>();
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.TrackPathsContainer#add(java.lang.String)
	 */
	@Override
	public void add(E element) {
		trackPaths.add(element);			
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.TrackPathsContainer#erase(java.lang.String)
	 */
	@Override
	public void erase(E element) {
		trackPaths.remove(element);
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.TrackPathsContainer#clear()
	 */
	@Override
	public void clear() {
		trackPaths.clear();
	}
	
	@Override
	public int size() {
		return trackPaths.size();
	}
	
	@Override
	public E get(int index) {
		return trackPaths.get(index);
	}

	@Override
	public BidirectionalIterator<E> createIterator() {
		return new BidirectionalArrayIterator<E>(this);
	}
}
