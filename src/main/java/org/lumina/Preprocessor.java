package org.lumina;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import edu.stanford.nlp.pipeline.Annotation;

public class Preprocessor {


    private StanfordCoreNLP pipeline;
    private static final Set<String> STOP_WORDS = Set.of(
            "a", "an", "the", "is", "are", "was", "were", "in", "on", "at", "for", "with", "about",
            "of", "and", "or", "but", "if", "then", "this", "that", "these", "those", "be", "been", "being"
    );

    public Preprocessor() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        this.pipeline = new StanfordCoreNLP(props);
    }

    public List<String> splitIntoSentences(String text) {
        Annotation document = new Annotation(text);
        pipeline.annotate(document);

        List<CoreMap> coreSentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        List<String> sentences = new ArrayList<>();

        for (CoreMap sentence : coreSentences) {
            sentences.add(sentence.toString());
        }
        return sentences;
    }

    public List<String> removeStopwords(List<String> sentences) {
        List<String> cleanedSentences = new ArrayList<>();

        for (String sentence : sentences) {
            Annotation annotation = new Annotation(sentence);
            pipeline.annotate(annotation);

            List<CoreLabel> tokens = annotation.get(CoreAnnotations.TokensAnnotation.class);
            List<String> words = new ArrayList<>();

            for (CoreLabel token : tokens) {
                String word = token.word().toLowerCase();
                if (!STOP_WORDS.contains(word)) {
                    words.add(word);
                }
            }
            cleanedSentences.add(String.join(" ", words));
        }
        return cleanedSentences;
    }
}
