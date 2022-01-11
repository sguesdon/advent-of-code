package aoc.day01;

import aoc.Day;

import java.util.List;

public class Day01 implements Day {

    @Override
    public String part1(List<String> input) {
        int total = 0;
        for(int i = 0; i < input.size(); i++) {
            if(i != (input.size() - 1) && Integer.parseInt(input.get(i + 1)) > Integer.parseInt(input.get(i))) {
                total += 1;
            }
        }
        return String.valueOf(total);
    }

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }

}
