package InternShip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Counter!");

        String text = getInputText(scanner);

    
        String[] words = text.split("\\s+|\\p{Punct}");

      
        int wordCount = 0;

       
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "of", "to", "in", "a", "it", "that", "was"));

        
        Map<String, Integer> wordFrequency = new HashMap<>();

      
        for (String word : words) {
            word = word.toLowerCase(); 

           
            if (stopWords.contains(word)) {
                continue;
            }

            
            wordCount++;

         
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

      
        System.out.println("Total words: " + wordCount);

       
        scanner.close();
    }

    private static String getInputText(Scanner scanner) {
        System.out.print("Enter text or provide the path to a file: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Input is empty. Please try again.");
            return getInputText(scanner);
        }

       
        File file = new File(input);
        if (file.exists() && file.isFile()) {
            try {
                return readFileContent(file);
            } catch (IOException e) {
                System.out.println("Error reading the file. Please try again.");
                return getInputText(scanner);
            }
        } else {
            return input;
        }
    }

    private static String readFileContent(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }
}

