import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        Integer[] numArr = {91, 7, 2, 38, 31, 76, 12, 15, 12, 3};
        System.gc();

        long startTime = System.nanoTime();

        Integer[] resultArr = genericSort(numArr);

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Sorted integer array: " + Arrays.toString(resultArr));
        System.out.println("Time elapsed: " + elapsedTime + " nano seconds\n");
    }

    // State what sorting algorithm the below method implements as a comment
    // DO NOT CHANGE THE FOLLOWING METHOD NAME 
    public static <T extends Comparable<? super T>> T[] genericSort (T[] data) {
        // Implement your sorting algorithm below

        // Bubble
        // for (int i = 1; i < data.length; i++) {
        //     boolean swap = false;

        //     for (int j = 0; j < data.length - i; j++) {
        //         if (data[j].compareTo(data[j + 1]) > 0) {
        //             T temp = data[j];
        //             data[j] = data[j + 1];
        //             data[j + 1] = temp;
        //             swap = true;
        //         }
        //     }

        //     if (!swap) {
        //         break;
        //     }
        // }

        // Selection
        // for (int i = 0; i < data.length - 1; i++) {
        //     int min = i;
        //     for (int j = i + 1; j < data.length; j++) {
        //         if (data[min].compareTo(data[j]) > 0) {
        //             min = j;
        //         }
        //     }

        //     if (min != i) {
        //         T temp = data[i];
        //         data[i] = data[min];
        //         data[min] = temp;
        //     }
        // }

        // Insertion
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    T temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return data;
    }

}
