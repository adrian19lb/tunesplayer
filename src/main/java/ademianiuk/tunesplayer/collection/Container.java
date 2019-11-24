package ademianiuk.tunesplayer.collection;

public interface Container<E> {

	void add(E element);

	void erase(E element);
	
	int size();
	
	E get(int index);

	void clear();

	BidirectionalIterator<E> createIterator();

}
