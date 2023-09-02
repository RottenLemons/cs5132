import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {

        Integer[] num = new Integer[10];
        num[0] = 10;
        num[1] = 7;
        num[2] = 2;
        num[3] = 39;
        num[4] = 32;
        num[5] = 76;
        num[6] = 12;
        num[7] = 16;
        num[8] = 12;
        num[9] = 1;

        System.out.println("Original List: " + Arrays.toString(num));
        System.out.println("Sorting list using HeapSort...");
        System.gc();
        long startTime = System.nanoTime();

        Integer[] resultArr = genericHeapSort(num);

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Sorted integer array: " + Arrays.toString(resultArr));
        System.out.println("Time elapsed: " + elapsedTime + " nano seconds\n");
    }

    // Complete the HeapSort below. Use the heapify method as an auxiliary method
    public static <T extends Comparable<? super T>> T[] genericHeapSort(T[] data) {
        heapify(data);
        System.out.println(Arrays.toString(data));
        int range = data.length;
        while (range != 0) {
            T temp = data[0];
            data[0] = data[range - 1];
            data[range - 1] = temp;
            range--;
            shiftDown(data, range);
            System.out.println("After iteration ...: " + Arrays.toString(data));
        }
        //Note that at after each iteration, you are to print out the array

        return data;
    }

    public static <T extends Comparable<? super T>> void shiftDown(T[] data, int range) {
        T temp;
        int node = 0, left = 1, right = 2;
        int next;

        if ((data[left] == null) && (data[right] == null)) {
            next = range - 1;
        } else if (data[right] == null) {
            next = left;
        } else if (data[left].compareTo(data[right]) > 0) {
            next = left;
        } else {
            next = right;
        }

        temp = data[node];

            
        while ((next < range) && (data[next].compareTo(temp)) > 0) {
            data[node] = data[next];
            node = next;
            left = 2 * node + 1;
            right = 2 * (node + 1);

            if (((left > range - 1) && (right > range - 1)) || ((data[left] == null) && (data[right] == null))) {
                next = range;
            } else if (right > range - 1 || data[right] == null) {
                next = left;
            } else if (data[left].compareTo(data[right]) > 0) {
                next = left;
            } else {
                next = right;
            }
        }

        data[node] = temp;
    }

    // Complete the generic heapify method below to create a heap.
    // You may edit / add as many parameters as you wish in this heappify method
    public static <T extends Comparable<? super T>> void heapify(T[] data) {
        for (int i = 1; i < data.length; i++) {
            T temp;
            int next = i;
            temp = data[next];

            while ((next != 0) && (temp.compareTo(data[(next-1)/2])) > 0) {
                data[next] = data[(next - 1)/2];
                next = (next - 1)/2;
            }
            data[next] = temp;
        }
    }
}

