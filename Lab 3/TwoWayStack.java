import java.util.Arrays;

public class TwoWayStack<E> implements TwoWayStackADT<E> {
    private int top, bottom, maxSize;
    private E[] arr;

    public TwoWayStack() {
        arr = (E[]) new Object[10];
        top = -1;
        bottom = 10;
        maxSize = 5;
    }

	//Checks that the top stack is empty
	public boolean topEmpty() {
        return top == -1;
    }
	
	//Checks that the bottom stack is empty
	public boolean bottomEmpty() {
        return bottom == arr.length;
    }
	
	//Returns first element in top stack, but does not pop it
	public E peekTop() {
        if (top == -1) {
            throw new EmptyCollectionException("Top Stack");
        }
        return arr[top];
    }
	
	//Returns first element in bottom stack, but does not pop it
	public E peekBottom() {
        if (top == 10) {
            throw new EmptyCollectionException("Bottom Stack");
        }
        return arr[bottom];
    }
	
	//Pushes an item into the top stack
	public void pushTop(E item) {
        if (top + 1 >= bottom) {
            enlargeArray();
        }

        top++;
        arr[top] = item;
    }
	
	//Pushes an item into the bottom stack
	public void pushBottom(E item) {
        if (bottom - 1 <= top) {
            enlargeArray();
        }

        bottom--;
        arr[bottom] = item;
    }
	
	//Returns the item popped from the top stack
	public E popTop() {
        if (topEmpty()) {
            throw new EmptyCollectionException("Top Stack");
        }

        E obj = arr[top];
        top--;
        return obj;
    }
	
	//Returns the item popped from the bottom stack
	public E popBottom() {
        if (topEmpty()) {
            throw new EmptyCollectionException("Top Stack");
        }

        E obj = arr[bottom];
        bottom++;
        return obj;
    }
	
	//Returns a string representation of this two way stack. 
    public String toString() {
        return Arrays.toString(arr);
    }

    private void enlargeArray() {
        int i;
        E[] arr2 = (E[]) new Object[maxSize * 4];
        
        for (i = 0; i <= top; i++) {
            arr2[i] = arr[i];
        }

        top = i - 1;

        for (i = 1; i <= (arr.length - bottom); i++) {
            arr2[arr2.length - i] = arr[arr.length - i];
        }
        
        bottom = arr2.length - i + 1;
        arr = arr2;
        maxSize = maxSize * 2;

    }
}
