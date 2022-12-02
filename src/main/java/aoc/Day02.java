package aoc;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/*
Keys for opponents:
A = Rock
B = Paper
C = Scissor
Keys for self:
X = Rock
Y = Paper
Z = Scissor
 */

public class Day02 {
    private static void solvePartTwo(String input) {
        final Map<String, Integer> outcomeScores = Map.of("X", 0, "Y", 3, "Z", 6);
        final Map<String, Integer> moveMap = Map.of(
                "A X", 3, "A Y", 1, "A Z", 2,
                "B X", 1, "B Y", 2, "B Z", 3,
                "C X", 2, "C Y", 3, "C Z", 1);

        Stream<String> lines = input.lines();
        AtomicInteger totalScore = new AtomicInteger();

        lines.forEach(line -> {
            // get score for outcome move
            int outcomeScore = outcomeScores.get(line.substring(line.length() - 1));
            // get move score and add to total
            totalScore.addAndGet(outcomeScore + moveMap.get(line));
        });
        System.out.println("Total score: " + totalScore);
    }
    private static void solvePartOne(String input) {
        final Map<String, Integer> moveScores = Map.of("X", 1, "Y", 2, "Z", 3);
        final Map<String, Integer> outcomeMap = Map.of(
                "A Y", 6, "A Z", 0, "A X", 3,
                "B Z", 6, "B X", 0, "B Y", 3,
                "C X", 6, "C Y", 0, "C Z", 3);
        Stream<String> lines = input.lines();
        AtomicInteger totalScore = new AtomicInteger();

        lines.forEach(line -> {
            // get score for response move
            int responseScore = moveScores.get(line.substring(line.length() - 1));
            // get outcome score and add to total
            totalScore.addAndGet(responseScore + outcomeMap.get(line));
        });
        System.out.println("Total score: " + totalScore);
    }


    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        String input = inputGetter.getPuzzleInputAsString("input/day02.in");
        solvePartOne(input);
        solvePartTwo(input);
    }
}