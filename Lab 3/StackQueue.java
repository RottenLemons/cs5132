public class StackQueue<T> implements QueueADT<T>{
    LinkedStack<T> add = new LinkedStack<T>();
    LinkedStack<T> sub = new LinkedStack<T>();
    public void enqueue (T element) {
        if (sub.isEmpty()) {
            add.push(element);
        } else {
            while (!sub.isEmpty()) {
                add.push(sub.pop());
            }
            add.push(element);
        }
    }

    /**  
     * Removes and returns the element at the front of this queue.
     * 
     * @return  the element at the front of this queue
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack Queue");
        } else if (add.isEmpty()) {
            return sub.pop();
        } else {
            while (!add.isEmpty()) {
                sub.push(add.pop());
            }
            return sub.pop();
        }
    }
 
    /**  
     * Returns without removing the element at the front of this queue.
     *
     * @return  the first element in this queue
     */
    public T first() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack Queue");
        } else if (add.isEmpty()) {
            return sub.peek();
        } else {
            while (!add.isEmpty()) {
                sub.push(add.pop());
            }
            return sub.peek();
        }
    }
    
    /**  
     * Returns true if this queue contains no elements.
     * 
     * @return  true if this queue is empty
     */
    public boolean isEmpty() {
        return add.isEmpty() && sub.isEmpty();
    }
 
    /**  
     * Returns the number of elements in this queue. 
     * 
     * @return  the integer representation of the size of this queue
     */
    public int size() {
        return sub.size() + add.size();
    }
 
    /**  
     * Returns a string representation of this queue. 
     *
     * @return  the string representation of this queue
     */
    public String toString() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack Queue");
        } else if (add.isEmpty()) {
            return sub.toString();
        } else {
            while (!add.isEmpty()) {
                sub.push(add.pop());
            }
            return sub.toString();
        }
    }
}
