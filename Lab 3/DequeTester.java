import java.util.Arrays;

public class DequeTester {
    public static void main(String Args[]) {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0;i < 10; i++) {
            deque.addLast(1);
        }
        deque.removeFirst();
        deque.removeFirst();
        for (int i = 0;i < 10; i++) {
            deque.addFirst(2);
        }
        deque.removeLast();
		System.out.println(Arrays.toString(deque.array));
	}
}
