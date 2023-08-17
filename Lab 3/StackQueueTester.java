public class StackQueueTester {
    public static void main(String Args[]) {
		StackQueue<Integer> mystacks = new StackQueue<Integer>();
		mystacks.enqueue(1);
        mystacks.enqueue(2);
        mystacks.enqueue(3);
        mystacks.dequeue();
		System.out.println(mystacks.toString());
	}
}
