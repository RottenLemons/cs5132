import java.util.*;

public class main {
    public static void main(String[] args) {
        HeadLinkedList<Character> list1 = new HeadLinkedList<Character>();
        list1.addToRear('a');
        list1.addToRear('b');
        list1.addToRear('c');
        list1.addToRear('d');
        System.out.println(list1.toString());
        list1.reverse();
        System.out.println(list1.toString());
        System.out.println(list1.frontBackSplit().toString());
        list1.addToRear('0');
        System.out.println(list1.frontBackSplit().toString());
    }
    
}
