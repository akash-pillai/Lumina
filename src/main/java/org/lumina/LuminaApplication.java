package org.lumina;


import java.util.List;

public class LuminaApplication {
    public static void main(String[] args) {


            InputHandler inputHandler = new InputHandler();
            Preprocessor preprocessor = new Preprocessor();
            Summarizer summarizer = new Summarizer();
            RiskAnalyzer riskAnalyzer = new RiskAnalyzer();
            OutputHandler outputHandler = new OutputHandler();

            try {
                String articleText = inputHandler.getInput();
                List<String> sentences = preprocessor.splitIntoSentences(articleText);
                List<String> cleanedSentences = preprocessor.removeStopwords(sentences);

                List<String> summary = summarizer.summarize(sentences, cleanedSentences);
                boolean riskDetected = riskAnalyzer.analyze(articleText);

                outputHandler.display(summary, riskDetected);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
    }

}