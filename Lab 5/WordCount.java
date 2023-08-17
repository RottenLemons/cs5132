import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class WordCount {
    private HashMap<String, Integer> dictionary;

    // Populates the dictionary by reading the text in the file called filename
    // All words are stored in lowercase with no punctuation or spaces
    // Hint: Use regex to remove the punctuation from all words
    public WordCount(String filename){
        // Complete the code below this comment
        dictionary = new HashMap<>();
        String[] words = readFileAsString("story.txt").replaceAll("\\.", " ").replaceAll("[^a-zA-Z ]", "").toLowerCase().split("[\\r\\n\\s]+");
        
        for (String word : words){
            if (dictionary.putIfAbsent(word, 1) != null) {
                dictionary.compute(word, (k, v) -> v + 1);
            }
        }
    }

    private String readFileAsString(String fileName)
    {
        try {
            String data = "";
            data = new String(
                Files.readAllBytes(Paths.get(fileName)));
            return data;
        } catch (Exception e) {
            return "null";
        }
    }

    // Returns the count for a given word
    // If the word cannot be found, return 0
    public int getCount(String word){
        // Complete the code below this comment
        return dictionary.getOrDefault(word, 0);
    }

    // Returns true if the dictionary has the word, false otherwise
    public boolean hasWord(String word){
        // Complete the code below this comment
        return dictionary.containsKey(word);
    }

    // Returns the word with the maximum count in the dictionary
    public String getWordWithMaxCount(){
        // Complete the code below this comment
        int maxValueInMap = (Collections.max(dictionary.values()));
         for (Entry<String, Integer> entry : dictionary.entrySet()) {
 
            if (entry.getValue() == maxValueInMap) {
                return entry.getKey();
            }
        } 
        return null;
    }

    // Returns an ArrayList of Strings of all unique words in the story.
    public ArrayList<String> getAllUniqueWords(){
        // Complete the code below this comment
        ArrayList<String> arr = new ArrayList<String>();

        for (String key : dictionary.keySet() ) {
            arr.add(key);
        }
        Collections.sort(arr);
        return arr;
    }

    @Override
    public String toString(){
        return dictionary.toString();
    }
}
