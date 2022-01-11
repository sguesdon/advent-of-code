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
        String res = EnumPatterns.removeValidPatterns(line);
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

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }
}
