# Luminia - AI-Based News Summarizer and Risk Analyzer

**Luminia** is an AI-based application that automatically summarizes long news articles and identifies potential risks such as misinformation or false information.  
The project uses **Stanford CoreNLP** for Natural Language Processing (NLP) tasks and **Jsoup** for web scraping.  

This system is designed to accept input from URLs or direct text input and provides a concise summary along with a risk analysis warning if necessary.

---

## ✨ Features

- Accepts news articles via:
  - Text input
  - URL scraping
- Preprocesses text using:
  - Sentence segmentation
  - Tokenization
  - Stopword removal
- Performs **Extractive Summarization** (selecting key sentences)
- Conducts **Risk Analysis** by detecting risky keywords like "fake", "misleading", "disinformation"
- Outputs:
  - Summarized article
  - Risk warning if risky keywords are found

---

## 🛠 Technology Stack

- Java 21
- Maven
- Stanford CoreNLP 4.5.4 (NLP processing)
- Jsoup 1.17.2 (web scraping)
- Ubuntu 24.04 (WSL environment)

---

## 📥 Installation

1. **Install Java 21**  
   (Make sure Java is installed.)

   ```bash
   java --version
2. **Install Maven**
   sudo apt update
   sudo apt install maven
   mvn -version

3. **Clone the repository**
   git clone https://github.com/akash-pillai/Lumina.git
   cd luminia

4. **Build the project**
   mvn clean install

5.**Run the application**
  mvn compile exec:java -Dexec.mainClass="org.lumina.LuminaApplication"

## 📂 Project Structure

     └── src/main/java/
         ├── LuminaApplication.java
         ├── InputHandler.java
         ├── Preprocessor.java
         ├── Summarizer.java
         ├── RiskAnalyzer.java
         └── OutputHandler.java
pom.xml
README.md

📄  Usage

    Run the application.

    Choose input type:

        (1) Enter a URL to fetch article text

        (2) Paste raw article text directly

    The system will:

        Preprocess and summarize the article.

        Analyze the article for risky keywords.

        Display the summarized text.

        Display a warning if risks are detected.

⚡ Future Enhancements

    Add PDF file upload and reading support (using Apache PDFBox)
    Export summarized result and risk report as downloadable PDF
    User-configurable summary size (short, medium, long)
    More advanced summarization using BERT or GPT integration
    Web-based user interface (using JavaFX or Spring Boot + Thymeleaf)

✨ Credits

    Stanford CoreNLP
    Jsoup
    Project done as part of "Software Principles" module.


   
