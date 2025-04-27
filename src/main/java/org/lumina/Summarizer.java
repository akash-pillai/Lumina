package org.lumina;

import java.util.ArrayList;
import java.util.List;

public class Summarizer {

    private static final double IMPORTANCE_THRESHOLD = 0.5;

    public List<String> summarize(List<String> originalSentences, List<String> cleanedSentences) {
        List<String> summary = new ArrayList<>();

        for (int i = 0; i < cleanedSentences.size(); i++) {
            double score = calculateImportance(cleanedSentences.get(i));
            if (score >= IMPORTANCE_THRESHOLD) {
                summary.add(originalSentences.get(i));
            }
        }
        return summary;
    }

    private double calculateImportance(String cleanedSentence) {
        String[] words = cleanedSentence.split("\\s+");
        return Math.min(1.0, words.length / 20.0); // Simple: longer sentence => more important
    }

}
