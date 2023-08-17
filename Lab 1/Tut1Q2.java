import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Boolean;
import java.util.HashMap;


public static void generatePermutations(ArrayList<String> permutations, String remaining, String current) {
    if (remaining.length() == 0) {
        permutations.add(current);
        return;
    }

    for (int i = 0; i < remaining.length(); i++) {
        char ch = remaining.charAt(i); 
        String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
        generatePermutations(permutations, newRemaining, current + ch); // Calls the recursive function again, but with a character added to current
    }
} 
// This is a recursive function that will be called repeatedly and efficiently will loop through and add a character. 
// Since the function is first called n times for each letter then n - 1 times (since 1 letter was removed from left) and so on until it 
// ends. Thus n + n-1 + ... + 2 + 1 = n*(n+1)/2 which is O(n**2) time complexity

public static boolean checkPermutation(char[] array1, char[] array2) {
    ArrayList<String> permutations = new ArrayList<String>();
    String string1 = String.valueOf(array1); // O(n) time complexity according to google
    String string2 = String.valueOf(array2); // O(n) time complexity according to google

    generatePermutations(permutations, string1, "");

    for (int i = 0; i < permutations.size(); i++) {
        if (permutations.get(i).equals(string2)) { // Checks if string2 is in the permutations
            return true;
        }
    } // O(n) time complexity

    return false;
}
// Thus as O(n**2) is the largest complexity, that is taken as the overall time complexity 


public static Boolean m2(char array1[], char array2[]){
    int counter = 0;
    for (int i = 0; i < array1.length; i++) {
        for (int j = 0; j < array2.length; j++) {
            if ((array1[i] == array2[j]) && (array1[i] != '!')) { // Check if 2 characters are the same, and they are not !
                counter++;
                array1[i] = '!';
                array2[j] = '!'; // This is to ensure that repeated letters are not counted with 1 letter
            }
        }
    }

    if (counter == array2.length){ 
        return true;
    } else {
        return false;
    }
}
// This is a pretty simple algorithm. We just loop throught both arrays and check if they contain the same letters since anagrams
// have to have the same letters. Counter is to verify that all the letters are the same

public static Boolean m3(char array1[], char array2[]){
    Arrays.sort(array2); // Is O(n log n)

    // Technically could have sorted other list and still would have gotten O(n log n) but felt like cheating (Idk any sorting algorithm so sorry)
    int counter = 0;
    for (int i = 0; i < array1.length; i++) {
        Boolean found = false;
        int l = 0;
        int r = array2.length - 1;
        while (l <= r) {
            int m = l + (r-1)/2;

            if (array2[m] == array1[i]) {
                found = true;
                break;
            } 

            if (array2[m] < array1[i]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (found == false) {
            return false;
        }
    }

    return true;
}

public static Boolean m4(char array1[], char array2[]){
    int numbers[] = new int[26];
    int numbers2[] = new int[26];
    for (int i = 0; i < array1.length; i++) {
        numbers[Character.getNumericValue(array1[i]) - Character.getNumericValue('a')] += 1;
    }

    for (int i = 0; i < array2.length; i++) {
        numbers2[Character.getNumericValue(array2[i]) - Character.getNumericValue('a')] += 1;
    }

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] != numbers2[i]) {
            return false;
        }
    }

    return true;
}

