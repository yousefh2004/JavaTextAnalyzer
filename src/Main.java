import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Step 1
        String paragraph = "the quick brown fox jumps over the lazy dog. " +
                "the dog was not amused. " +
                "there were 3 foxes and 12 dogs in total that day.";

        // Step 2
        TextAnalyzer analyzer = new TextAnalyzer(paragraph);

        // Step 3
        System.out.println("Cleaned Words:");
        System.out.println(analyzer.getCleanWords());
        System.out.println();

        // Step 4
        System.out.println("Summary Line:");
        System.out.println(analyzer.buildSummaryLine());
        System.out.println();

        // Step 5
        System.out.println("Sum of Numbers:");
        System.out.println(analyzer.sumNumbers());
        System.out.println();

        // Step 6
        System.out.println("Total Word Count: " + analyzer.getAllWords().size());
        System.out.println("Unique Word Count: " + analyzer.getUniqueWords().size());
        System.out.println();

        // Step 7
        System.out.println("Frequency Table:");
        Map<String, Integer> frequency = analyzer.getWordFrequency();
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        // Step 8
        System.out.println("Most Frequent Word: " + analyzer.getMostFrequentWord());
        System.out.println();

        // Step 9
        System.out.println("Words Appearing Once:");
        System.out.println(analyzer.getWordsAppearingOnce());
        System.out.println();

        // Step 10
        System.out.println("containsBothWords(\"fox\", \"dog\"): " + analyzer.containsBothWords("fox", "dog"));
        System.out.println("containsBothWords(\"fox\", \"cat\"): " + analyzer.containsBothWords("fox", "cat"));
        System.out.println();

        // Step 11: Print the top 3 most frequent words
        System.out.println("Top 3 Words:");
        List<String> topWords = analyzer.getTopFrequentWords(3);
        Map<String, Integer> frequencyForTop = analyzer.getWordFrequency();
        for (String word : topWords) {
            System.out.println(word + " (" + frequencyForTop.get(word) + ")");
        }
        System.out.println();

        //Bonuses
        System.out.println("Bonus - Longest Word: " + analyzer.getLongestWord());
        System.out.println("Bonus - Palindrome Count: " + analyzer.countPalindromes());

    }

}