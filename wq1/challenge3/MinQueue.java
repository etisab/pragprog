//for-fun implementation of a heap

class MinQueue {
	static final int DEFAULT_SIZE = 10;
	Object[] elements;
	
	//false --> min heap. true --> max heap.
	MinQueue(int size, boolean isMax) {
		elements = new Object[size];
		
	}
	
	MinQueue(boolean isMax) {
		this.MinQueue(DEFAULT_SIZE, isMax);
	}
}