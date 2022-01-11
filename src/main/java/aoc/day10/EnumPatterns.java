package aoc.day10;

import java.util.Arrays;
import java.util.Optional;

public enum EnumPatterns {

    CROCHETS ("[", "]", 57),
    PARENTHESES("(", ")", 3),
    ACCOLADES("{", "}", 1197),
    CHEVRONS("<", ">", 25137);

    private final String startChar;
    private final String endChar;
    private final int points;

    EnumPatterns(String startChar, String endChar, int points) {
        this.startChar = startChar;
        this.endChar = endChar;
        this.points = points;
    }

    public static Optional<EnumPatterns> findEnumWithCloseChar(char car) {
        return Arrays.stream(EnumPatterns.values())
            .filter(enumPatterns -> enumPatterns.getEndChar().equals(String.valueOf(car)))
            .findFirst();
    }

    public static String removeValidPatterns(String line) {

        if(line.isEmpty()) {
            return "";
        }

        String prevLine = "";
        String currentLine = line;

        while(!currentLine.equals(prevLine)) {
            prevLine = currentLine;
            currentLine = EnumPatterns.removeOnceValidPatterns(currentLine);
        }

        return currentLine;
    }

    private static String removeOnceValidPatterns(String line) {

        for(EnumPatterns pattern : EnumPatterns.values()) {

            line = line.replace(pattern.getStartChar() + pattern.getEndChar(), "");

            if(line.length() >= 2) {

                final String currentStartChar = line.substring(0);
                final String currentLastChar = line.substring(line.length() - 1);

                if(currentStartChar.equals(pattern.getStartChar()) && currentLastChar.equals(pattern.getEndChar())) {
                    line = line.substring(1, line.length() - 2);
                }
            }
        }

        return line;
    }

    public String getStartChar() {
        return startChar;
    }

    public String getEndChar() {
        return endChar;
    }

    public int getPoints() {
        return points;
    }
}
