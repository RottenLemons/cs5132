import java.util.Arrays;

public class Deque<T> implements DequeADT<T> {
	private static final int DEFAULT_SIZE = 10;
	T[] array = (T[]) new Object[DEFAULT_SIZE];
	private int count = 0;
	private int first = 0;
	private int last = DEFAULT_SIZE - 1;
	
	public int size() {
		return count;
	}
	public boolean isEmpty() {
		return count == 0;
	}
	public T getFirst() {
		return array[first];
	}
	public T getLast() {
		return array[last];
	}
	public void addFirst(T element) {
		if (size() == array.length) {
			expandCapacity();
		}

		first = (first - 1) % array.length;
		if (first < 0) first += array.length;
		array[first] = element;
		count++;
	}
	public void addLast(T element) {
		if (size() == array.length) {
			expandCapacity();
		}

		last = (last + 1) % array.length;
		array[last] = element;
		count++;
	}
	public T removeFirst() {
		if (isEmpty()) throw new EmptyCollectionException("Deque");
		T element = array[first];
		array[first] = null;
		first = (first + 1) % array.length;
		count--;
		return element;
	}
	public T removeLast() {
		if (isEmpty()) throw new EmptyCollectionException("Deque");
		T element = array[last];
		array[last] = null;
		last = (last - 1) % array.length;
		if (last < 0) last += array.length;
		count--;
		return element;
	}

	private void expandCapacity() {
		T[] array2 = (T[]) new Object[size() * 2];
		for (int i = 0; i < size(); i++) {
			int index = i % size();
			array2[i] = array[index];
		}

		first = 0;
		last = size() - 1;
		array = array2;
	}
}
