/*
    Miranda Germain
    SpellChecker.java
    March 15. 2023
    CSC 190

    The purpose of this class is to compare words from the sample file to
    a words file in order to check the spelling in the sample file. The
    misspelled words will be outputted to the console.
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SpellChecker {
    public static void main(String[] args) throws Exception {
        // Create Scanner Objects in order to read from the files
        Scanner inputSample = new Scanner(new File("sample.txt"));
        Scanner inputWord = new Scanner(new File("words.txt"));

        // Create ArrayLists in order to hold input from the files
        List<String> sampleList = new ArrayList<String>();
        List<String> wordList = new ArrayList<String>();

        // Create a string of possible punctuation
        String[] punctuation = {(","),("."),("!"),("\n"),(";"),(":"), ("-"),
                ("&")};

        // Check in there's still words in the sample file
        while (inputSample.hasNext()) {
            // Create a string in order to manipulate possible word input in
            // case of punctuation
            String sample = inputSample.next().toLowerCase();

            // Check if the particular word has punctuation
            for(int i = 0; i < punctuation.length; i++) {
                // If punctuation is at the end append string as necessary
                if(sample.endsWith(punctuation[i])) {
                    sample = sample.substring(0, sample.length() - 1);
                }
                // If the word begins with punctuation remove it from the
                // beginning
                if(sample.startsWith(punctuation[i])) {
                    sample = sample.substring(sample.lastIndexOf
                            (punctuation[i]) + 1, sample.length());
                }
            }

            // Add the word to the sample text ArrayList
            sampleList.add(sample);
        }

        // Close sample Scanner
        inputSample.close();

        // Check file to make sure there's still words to be read
        while (inputWord.hasNextLine()) {
            // Add word to the word checking text array list
            wordList.add(inputWord.nextLine());
        }

        // Close word checker list Scanner
        inputWord.close();

        // Create a file to print incorrect words to
        PrintWriter output = new PrintWriter(new File("incorrect.txt"));

        // Check if the sample text word is within the spell checker list
        for (int i = 0; i < sampleList.size(); i++) {
            // If a word from the sample text is not within the checker list
            // print the sample text word to the "incorrect.txt" file
            if (!wordList.contains(sampleList.get(i))) {
                output.print(sampleList.get(i) + " ");
            }

            // Insert a new line into text file for readability
            // Does not work as intended due to the count keeping track of
            // numbers in sampleList not the file itself.
            if (i % 40 == 0) {
                output.println();
            }
        }

        // Close output in order to save contents of the file
        output.close();

    }
}