package org.lumina;

import org.jsoup.Jsoup;


import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Scanner;

public class InputHandler {

    public String getInput() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input type: (1) URL (2) Text");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.println("Enter the URL:");
            String url = scanner.nextLine();
            return fetchFromUrl(url);
        } else if (choice == 2) {
            System.out.println("Paste your text:");
            return scanner.nextLine();
        } else {
            throw new IllegalArgumentException("Invalid choice.");
        }
    }

    private String fetchFromUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.body().text();
    }
}
