package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 {
    private static boolean checkPartialOverlap(int[] elf1, int[] elf2) {
        if ((elf1[0] >= elf2[0] && elf1[0] <= elf2[1])
                || (elf2[0] >= elf1[0] && elf2[0] <= elf1[1])) {
            return true;
        }
        return false;
    }

    private static boolean checkFullOverlap(int[] elf1, int[] elf2) {
        if ((elf1[0] >= elf2[0] && elf1[1] <= elf2[1])
            || (elf2[0] >= elf1[0] && elf2[1] <= elf1[1])) {
            return true;
        }
        return false;
    }

    private static List<int[]> parsePairs(String line) {
        int[] sections = Arrays.stream(line.split("[-,]")).mapToInt(Integer::parseInt).toArray();
        List<int[]> pairs = new ArrayList<int[]>(2);
        pairs.add(new int[]{sections[0], sections[1]}); // elf 1
        pairs.add(new int[]{sections[2], sections[3]}); // elf 2
        return pairs;
    }

    private static void solvePartOne(List<String> input) {
        long fullyOverlappingPairs = 0;

        fullyOverlappingPairs = input.stream()
                                    .map(line -> parsePairs(line))
                                    .filter(pair -> checkFullOverlap(pair.get(0), pair.get(1)))
                                    .count();

        System.out.println("Fully overlapping pairs: " + fullyOverlappingPairs);
    }

    private static void solvePartTwo(List<String> input) {
        long overlappingPairs = 0;

        overlappingPairs = input.stream()
                                .map(line -> parsePairs(line))
                                .filter(pair -> checkPartialOverlap(pair.get(0), pair.get(1)))
                                .count();

        System.out.println("Overlapping pairs: " + overlappingPairs);
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        List<String> input = inputGetter.getPuzzleInputAsStringList("input/day04.in");

        solvePartOne(input);
        solvePartTwo(input);
    }
}
