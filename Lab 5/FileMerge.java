import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class FileMerge {
    public static void main(String[] args) {
        // Complete your code below this comment
        Person[] records1 = new Person[499816];
        Person[] records2 = new Person[500184];
        Person[] records3 = new Person[1000000];
        String line = "";  
        String splitBy = ",";  
        try {  
            BufferedReader br = new BufferedReader(new FileReader("records1.csv"));  
            int counter = 0;
            while ((line = br.readLine()) != null) {  
                String[] person = line.split(splitBy);    
                records1[counter] = new Person(Integer.parseInt(person[0]), person[1], person[2], person[3]);
                counter++;
            }  

            br = new BufferedReader(new FileReader("records2.csv"));  
            counter = 0;
            while ((line = br.readLine()) != null) {  
                String[] person = line.split(splitBy);    
                records2[counter] = new Person(Integer.parseInt(person[0]), person[1], person[2], person[3]);
                counter++;
            }  

            records3 = merge(records1, records2);
            File csvFile = new File("recordsAll.csv");
            PrintStream fileStream = new PrintStream(csvFile);
            for (Person data : records3) {
                fileStream.println(data.toString());
            }
            fileStream.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }

    public static Person[] merge(Person[] arr1, Person[] arr2) {
        Person[] temp = new Person[arr1.length + arr2.length];
        int l = 0, r = 0, tpIdx = 0;
        while (l < arr1.length && r < arr2.length) {
            if (arr1[l].getId() <= arr2[r].getId()) {
                temp[tpIdx] = arr1[l];
                l++;
                tpIdx++;
            } else {
                temp[tpIdx] = arr2[r];
                r++;
                tpIdx++;
            }
        }

        while (l < arr1.length) {
            temp[tpIdx] = arr1[l];
            l++;
            tpIdx++;
        }

        while (r < arr2.length) {
            temp[tpIdx] = arr2[r];
            r++;
            tpIdx++;
        }

        return temp;
    }
}
