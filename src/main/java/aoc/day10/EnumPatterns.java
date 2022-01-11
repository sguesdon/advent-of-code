package aoc.day10;

import java.util.Arrays;
import java.util.Optional;

public enum EnumPatterns {

    CROCHETS ("[", "]", 57),
    PARENTHESES("(", ")", 3),
    ACCOLADES("{", "}", 1197),
    CHEVRONS("<", ">", 25137);

    private final String openChar;
    private final String closeChar;
    private final int points;

    EnumPatterns(String openChar, String closeChar, int points) {
        this.openChar = openChar;
        this.closeChar = closeChar;
        this.points = points;
    }

    public static Optional<EnumPatterns> findEnumWithCloseChar(char car) {
        return Arrays.stream(EnumPatterns.values())
            .filter(enumPatterns -> enumPatterns.getCloseChar().equals(String.valueOf(car)))
            .findFirst();
    }

    public String getOpenChar() {
        return openChar;
    }

    public String getCloseChar() {
        return closeChar;
    }

    public int getPoints() {
        return points;
    }
}
