package aoc;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/*
Keys for opponents:
A = Rock
B = Paper
C = Scissor

R + P = W
R + S = L
R + R = D
P + S = W
P + R = L
P + P = D
S + R = W
S + P = L
S + S = D
 */

public class Day02 {
    private static void calculateTotalScore(String input, Map<String, Integer> symbolMap, Map<String, Integer> comboMap) {
        Stream<String> lines = input.lines();
        AtomicInteger totalScore = new AtomicInteger();

        lines.forEach(line -> {
            // get score for 2nd column symbol
            int secondColumnScore = symbolMap.get(line.substring(line.length() - 1));
            // get value of 3rd factor (move/outcome) and add to total
            totalScore.addAndGet(secondColumnScore + comboMap.get(line));
        });
        System.out.println("Total score: " + totalScore);
    }

    private static void solvePartTwo(String input) {
        final Map<String, Integer> outcomeScores = Map.of("X", 0, "Y", 3, "Z", 6);
        final Map<String, Integer> moveMap = Map.of(
                "A X", 3, "A Y", 1, "A Z", 2,
                "B X", 1, "B Y", 2, "B Z", 3,
                "C X", 2, "C Y", 3, "C Z", 1);

        calculateTotalScore(input, outcomeScores, moveMap);
    }

    private static void solvePartOne(String input) {
        final Map<String, Integer> moveScores = Map.of("X", 1, "Y", 2, "Z", 3);
        final Map<String, Integer> outcomeMap = Map.of(
                "A Y", 6, "A Z", 0, "A X", 3,
                "B Z", 6, "B X", 0, "B Y", 3,
                "C X", 6, "C Y", 0, "C Z", 3);

        calculateTotalScore(input, moveScores, outcomeMap);
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        String input = inputGetter.getPuzzleInputAsString("input/day02.in");
        solvePartOne(input);
        solvePartTwo(input);
    }
}