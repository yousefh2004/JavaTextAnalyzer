import java.util.*;

public class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text must not be null or empty.");
        }
        this.text = text;
    }

    //part A1
    public List<String> getCleanWords() {
        String cleaned = text.toLowerCase().trim();
        cleaned = cleaned.replaceAll("[.,!?]", ""); //punctuation
        String[] parts = cleaned.split("\\s+");
        List<String> words = new ArrayList<>();
        for(String part : parts){
            if(!part.isEmpty()){
                words.add(part);
            }
        }
        return words;
    }

    //part A2
    public int getWordLength(String word) {
        return word.length();
    }

    public boolean startsWithLetter(String word, String letter) {
        return word.startsWith(letter);
    }

    public boolean containsSequence(String word, String sequence) {
        return word.contains(sequence);
    }

    public String toUpperCase(String word) {
        return word.toUpperCase();
    }

    //part A3
    public String buildSummaryLine() {
        List<String> words = getCleanWords();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(words.get(i));
            if (i < 4) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    //part A4
    public int sumNumbers() {
        List<String> words = getCleanWords();
        int sum=0;
        for (String word : words) {
            try {
                int number = Integer.parseInt(word);
                sum += number;
            } catch (NumberFormatException e) {
                //no crash
            }
        }
        return sum;
    }

    //part B1
    // List selected because we need to keep duplicates and keep the order
    //Average lookup complexity : O(n) by value
    public List<String> getAllWords() {
        return getCleanWords();
    }

    //part B2
    //HashSet selected because order does not matter and duplicates are not allowed
    //Average lookup complexity : O(1)
    public Set<String> getUniqueWords() {
        return new HashSet<>(getCleanWords());
    }

    //part B3
    //HashMap selected because we need key,value
    //Average lookup complexity : O(1)
    public Map<String, Integer> getWordFrequency() {
        Map<String, Integer> frequency = new HashMap<>();
        for(String word : getCleanWords()){
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        return frequency;
    }

    //part B4
    public String getMostFrequentWord() {
        Map<String, Integer> frequency = getWordFrequency();
        String mostFrequent = null;
        int highestCount = -1;

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

    //part B5
    public List<String> getWordsAppearingOnce() {
        Map<String, Integer> frequency = getWordFrequency();
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    //part B6
    //HashSet selected because order does not matter
    //Average lookup complexity : O(1) because O(1) + O(1) = O(1)
    public boolean containsBothWords(String word1, String word2) {
        Set<String> uniqueWords = getUniqueWords();
        return uniqueWords.contains(word1) && uniqueWords.contains(word2);
    }

    //part B7
    public List<String> getTopFrequentWords(int n) {
        Map<String, Integer> frequency = getWordFrequency();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequency.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        List<String> topWords = new ArrayList<>();
        int limit = Math.min(n, entryList.size());//I put it if there is less than n
        for (int i = 0; i < limit; i++) {
            topWords.add(entryList.get(i).getKey());
        }
        return topWords;
    }

    //Bonuses

    //Longest word
    public String getLongestWord() {
        List<String> words = getCleanWords();
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    //palindrome
    public int countPalindromes() {
        List<String> words = getCleanWords();
        int count = 0;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed) && word.length() > 1) {
                count++;
            }
        }
        return count;
    }


}

