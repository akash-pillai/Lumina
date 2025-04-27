package org.lumina;

import java.util.List;

public class OutputHandler {

    public void display(List<String> summary, boolean isRisky) {
        System.out.println("\n--- SUMMARY ---");
        for (String sentence : summary) {
            System.out.println("- " + sentence);
        }

        System.out.println("\n--- RISK ANALYSIS ---");
        if (isRisky) {
            System.out.println("⚠️ WARNING: Potential misleading or false information detected!");
        } else {
            System.out.println("✅ Article appears safe.");
        }
    }
}
