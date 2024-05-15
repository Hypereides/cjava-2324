import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TextAnalyzerApp {

    public static void main(String[] args) {
        String filePath = "data/ex.txt";
        analyzeText(filePath);
    }

    public static Map<String, WordStats> analyzeText(String filePath) {
        Map<String, WordStats> wordStatsMap = new HashMap<>();
        Path tempFilePath = Paths.get("temp_results.txt");
        try {
            Files.deleteIfExists(tempFilePath);
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
                 BufferedWriter writer = Files.newBufferedWriter(tempFilePath)) {
                String line;
                int sentenceNumber = 0;
                while ((line = reader.readLine()) != null) {
                    sentenceNumber++;
                    String[] words = line.split("\\s+");
                    for (int i = 0; i < words.length; i++) {
                        String word = words[i].replaceAll("\\p{Punct}", "").toLowerCase();
                        WordStats wordStats = wordStatsMap.getOrDefault(word, new WordStats());
                        wordStats.totalCount++;
                        if (wordStats.firstSentence == 0) {
                            wordStats.firstSentence = sentenceNumber;
                        }
                        SentenceStats sentenceStats = wordStats.sentenceStats.getOrDefault(sentenceNumber, new SentenceStats());
                        if (sentenceStats.count == 0) {
                            wordStats.sentenceCount++;
                        }
                        sentenceStats.sentenceNumber = sentenceNumber;
                        sentenceStats.count++;
                        sentenceStats.positions.add(i);
                        wordStats.sentenceStats.put(sentenceNumber, sentenceStats);
                        if (sentenceStats.count > wordStats.mostOccurrencesSentence) {
                            wordStats.mostOccurrencesSentence = sentenceStats.count;
                        }
                        wordStatsMap.put(word, wordStats);
                    }
                }
                for (Map.Entry<String, WordStats> entry : wordStatsMap.entrySet()) {
                    String result = "\n-----------------------------\n" +
                            "Word: " + entry.getKey() + "\n" +
                            "Total count: " + entry.getValue().totalCount + "\n" +
                            "Sentence count: " + entry.getValue().sentenceCount + "\n" +
                            "First sentence: " + entry.getValue().firstSentence + "\n" +
                            "Most occurrences sentence: " + entry.getValue().mostOccurrencesSentence + "\n";
                    for (SentenceStats sentenceStats : entry.getValue().sentenceStats.values()) {
                        result += "\n\tSentence number: " + sentenceStats.sentenceNumber + "\n" +
                                "\tCount in sentence: " + sentenceStats.count + "\n" +
                                "\tPositions in sentence: " + sentenceStats.positions + "\n";
                    }
                    result += "-----------------------------\n";
                    writer.write(result);
                    System.out.println(result); 
                }
            }
            System.out.println("The results are also written to the file: " + tempFilePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return wordStatsMap;
    }
}