package ademianiuk.tunesplayer.collection;

public class BidirectionalArrayIterator<E> implements BidirectionalIterator<E>  {
	private Container<E> container;
	private int counter;
	private E currentElement;
	
	private final int FIRST_INDEX;
	private final int LAST_INDEX;
	
	public BidirectionalArrayIterator(Container<E> container) {
		this.container = container;
		this.LAST_INDEX = container.size() - 1;
		this.FIRST_INDEX = 0;
		
		currentElement = first();
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.Iterator#next()
	 */
	@Override
	public E next() {
		try {
			++counter;
			currentElement = container.get(counter);
			return currentElement;
		}catch (IndexOutOfBoundsException error) {
			return first();
		}
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.Iterator#previous()
	 */
	@Override
	public E previous() {
		try {
			--counter;
			currentElement = container.get(counter);
			return currentElement;
		}catch (IndexOutOfBoundsException error) {
			return last();
		}
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.Iterator#first()
	 */
	@Override
	public E first() {
		this.counter = FIRST_INDEX;
		currentElement = container.get(counter);
		
		return currentElement;
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.Iterator#last()
	 */
	@Override
	public E last() {
		this.counter = LAST_INDEX;
		currentElement = container.get(counter);
		
		return currentElement;
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.Iterator#current()
	 */
	@Override
	public E current() {
		return currentElement;
	}
	
	/* (non-Javadoc)
	 * @see ademianiuk.tunesplayer.core.Iterator#index()
	 */
	@Override
	public int index() {
		return counter;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return container.size();
	}
}
