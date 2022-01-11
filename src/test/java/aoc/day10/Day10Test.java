package aoc.day10;


import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class Day10Test {

    @Test
    public void should_test_invalid_str1(){
        List<String> input = Collections.singletonList("())");
        String result = new Day10().part1(input);
        assertEquals("3", result);
    }

    @Test
    public void should_test_invalid_str2(){
        List<String> input = Collections.singletonList("()(");
        String result = new Day10().part1(input);
        assertEquals("0", result);
    }

    @Test
    public void should_test_invalid_str3(){
        List<String> input = Collections.singletonList("(])");
        String result = new Day10().part1(input);
        assertEquals("57", result);
    }

    @Test
    public void should_test_invalid_str4(){
        List<String> input = Collections.singletonList("([)");
        String result = new Day10().part1(input);
        assertEquals("3", result);
    }

    @Test
    public void testScore() {
        final Day10 day10 = new Day10();
        assertThat(day10.getScore(")"), equalTo(3));
        assertThat(day10.getScore("]"), equalTo(57));
        assertThat(day10.getScore("}"), equalTo(1197));
        assertThat(day10.getScore(">"), equalTo(25137));

        assertThat(day10.getScore("()"), equalTo(0));
        assertThat(day10.getScore("[]"), equalTo(0));
        assertThat(day10.getScore("{}"), equalTo(0));
        assertThat(day10.getScore("<>"), equalTo(0));
        assertThat(day10.getScore("<>[]"), equalTo(0));

        assertThat(day10.getScore("())"), equalTo(3));
        assertThat(day10.getScore("[]]"), equalTo(57));
        assertThat(day10.getScore("{}}"), equalTo(1197));
        assertThat(day10.getScore("<>>"), equalTo(25137));

        assertThat(day10.getScore("("), equalTo(0));

        assertThat(day10.getScore("(()"), equalTo(0));
        assertThat(day10.getScore("([]"), equalTo(0));

        assertThat(day10.getScore("()("), equalTo(0));
        assertThat(day10.getScore("([)"), equalTo(3));
        assertThat(day10.getScore("([)]"), equalTo(3));
        assertThat(day10.getScore("(])"), equalTo(57));

        assertThat(day10.getScore("[({(<(())[]>[[{[]{<()<>>"), equalTo(0));
        assertThat(day10.getScore("[(()[<>])]({[<{<<[]>>("), equalTo(0));
        assertThat(day10.getScore("{([(<{}[<>[]}>{[]{[(<()>"), equalTo(1197));
        assertThat(day10.getScore("(((({<>}<{<{<>}{[]{[]{}"), equalTo(0));
        assertThat(day10.getScore("[[<[([]))<([[{}[[()]]]"), equalTo(3));
        assertThat(day10.getScore("[{[{({}]{}}([{[{{{}}([]"), equalTo(57));
        assertThat(day10.getScore("{<[[]]>}<{[{[{[]{()[[[]"), equalTo(0));
        assertThat(day10.getScore("[<(<(<(<{}))><([]([]()"), equalTo(3));
        assertThat(day10.getScore("<{([([[(<>()){}]>(<<{{"), equalTo(25137));
        assertThat(day10.getScore("<{([{{}}[<[[[<>{}]]]>[]]"), equalTo(0));
    }

}
