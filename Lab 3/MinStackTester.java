public class MinStackTester {

	public static void main(String Args[]) {
		MinStack<Integer> mystacks = new MinStack<Integer>();
		mystacks.push(1);
		System.out.println(mystacks.min());
		mystacks.push(3);
		System.out.println(mystacks.min());
		mystacks.push(-1);
		System.out.println(mystacks.min());
		mystacks.push(10);
		System.out.println(mystacks.min());
		mystacks.push(-2);
		System.out.println(mystacks.min());
		mystacks.pop();
		System.out.println(mystacks.min());
		mystacks.pop();
		System.out.println(mystacks.min());
		mystacks.pop();
		System.out.println(mystacks.min());
		mystacks.pop();
		System.out.println(mystacks.min());
	}
}
