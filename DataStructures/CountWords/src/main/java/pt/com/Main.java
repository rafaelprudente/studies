package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println("Number of words in the sentence: " + countWords("This is a sample sentence to count words"));
    }

    public static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        return sentence.trim().split("\\s+").length;
    }
}