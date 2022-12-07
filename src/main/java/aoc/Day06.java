package aoc;

import java.util.stream.IntStream;

public class Day06 {
    private static void solvePuzzle(String input, int markerLength) {
        for (int i = 0; i < input.length(); i++) {
            IntStream distinctString = input.substring(i, i + markerLength).chars().distinct();
            if (distinctString.count() == markerLength) {
                System.out.println("Marker found at index " + (i + markerLength));
                return;
            }
        }
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        String input = inputGetter.getPuzzleInputAsString("input/day06.in");
        if (input == null)
            System.exit(1);

        solvePuzzle(input, 4); // part 1
        solvePuzzle(input, 14); // part 2
    }
}
