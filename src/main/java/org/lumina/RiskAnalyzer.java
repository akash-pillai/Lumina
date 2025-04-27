package org.lumina;

import java.util.List;

public class RiskAnalyzer {

    private static final List<String> RISK_KEYWORDS = List.of(
            "misleading", "fake", "disinformation", "risk", "warning", "hoax", "rumor"
    );

    public boolean analyze(String text) {
        text = text.toLowerCase();
        for (String keyword : RISK_KEYWORDS) {
            if (text.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
