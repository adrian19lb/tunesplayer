package ademianiuk.tunesplayer.collection;

public class IntegerCounter {
	
	public Integer counter;
	private final int START_VALUE;
	
	public IntegerCounter() {
		this.START_VALUE = 0;
		this.counter = START_VALUE;
	}
	
	public IntegerCounter(int startValue) {
		this.START_VALUE = startValue;
		this.counter = startValue;
	}

	public void increment() {
		++counter;
		
	}

	public void decrement() {
		if (counter > START_VALUE) {
			--counter;
		}
	}
	
	public void restart() {
		counter = START_VALUE;
	}
	
	public boolean isEqual(int number) {
		return counter == number;
	}
}
