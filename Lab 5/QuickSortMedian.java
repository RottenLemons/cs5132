import java.util.Arrays;

public class QuickSortMedian {
    public static void main(String[] args) {
        int[] intArray = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(quickSortMedian(intArray)));
    }

    public static int[] quickSortMedian(int[] intArray){
        int[] result = intArray;
        quickSortMedian(result, 0, intArray.length-1);
        return result;
    }

    // Do NOT modify the method name and parameter signature.
    public static void quickSortMedian(int[] intArray, int left, int right) {
        // Complete your code below the comment
        // You are free to add any number of auxiliary methods to aid you in the implementation
        if (right > left) {
            int pivot = partition(intArray, left, right);
            quickSortMedian(intArray, left, pivot - 1);
            quickSortMedian(intArray, pivot + 1, right);
        }
    }

    public static int partition(int[] intArray, int left, int right) {
        int median = median(intArray, left, right);
        if (median != left) {
            int temp = intArray[left];
            intArray[left] = intArray[median];
            intArray[median] = temp;
        }
        int low = left + 1;
        int high = right;
        

        while (high > low) {
            while (low <= high && intArray[low] <= intArray[left]) 
                low++;
            while (low <= high && intArray[high] > intArray[left])
                high--;

            if (high > low) {
                int temp = intArray[low];
                intArray[low] = intArray[high];
                intArray[high] = temp;                
            }
        }

        while (high > left && intArray[high] >= intArray[left])
            high--;

        if (intArray[left] > intArray[high]) {
            int temp = intArray[left];
            intArray[left] = intArray[high];
            intArray[high] = temp;   
            return high;
        } else {
            return left;
        }

    }

    public static int median(int a[], int p, int r) {
        int m = (p+r)/2;
        if(a[p] < a[m])
        {
            if(a[p] >= a[r])
                return p;
            else if(a[m] < a[r])
                return m;
        }
        else
        {
            if(a[p] < a[r])
                return p;
            else if(a[m] >= a[r])
                return m;
        }
        return r;
    }

}
