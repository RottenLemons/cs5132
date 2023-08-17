public class MinStack<E extends Comparable<E>>{
	ArrayStack<E> min = new ArrayStack<E>();
    ArrayStack<E> stack = new ArrayStack<E>();
	//complete the code required for MinStack to work
	public void push(E element){
        if (stack.isEmpty()) {
            min.push(element);
        }
        if (element.compareTo(min.peek()) < 0) {
            min.push(element);
        }
        stack.push(element);
	}
	public E peek(){
		return stack.peek();
	}
	public E pop(){
        if (stack.peek() == min.peek()) {
            min.pop();
        }
		return stack.pop();
	}
	public E min(){
		return min.peek();
	}
}

