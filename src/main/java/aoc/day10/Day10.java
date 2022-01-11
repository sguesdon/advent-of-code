package aoc.day10;

import aoc.Day;

import java.util.List;
import java.util.Optional;

public class Day10 implements Day {

    @Override
    public String part1(List<String> input) {
        int points = 0;
        for(String line : input) {
            points = getScore(line);
        }
        return String.valueOf(points);
    }

    public int getScore(String line) {
        String res = this.removePart(line);
        if(res.length() > 0) {
            for(char car : res.toCharArray()) {
                Optional<EnumPatterns> optPattern = EnumPatterns.findEnumWithCloseChar(car);
                if(optPattern.isPresent()) {
                    return optPattern.get().getPoints();
                }
            }
        }
        return 0;
    }

    private String removePart(String line) {

        if(line.length() == 0) {
            return line;
        }

        int currentLen = line.length();

        for(EnumPatterns pattern : EnumPatterns.values()) {

            line = line.replace(pattern.getOpenChar() + pattern.getCloseChar(), "");

            if(line.substring(0).equals(pattern.getOpenChar()) && line.substring(line.length() - 1).equals(pattern.getCloseChar())) {
                line = line.substring(1, line.length() - 2);
            }
        }

        int afterReplaceLen = line.length();

        if(currentLen == afterReplaceLen) {
            return line;
        }

        return this.removePart(line);
    }

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }
}
