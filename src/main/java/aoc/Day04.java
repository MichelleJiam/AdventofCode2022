package aoc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class Day04 {

    private static int checkOverlap(String elf1, String elf2, IntBinaryOperator op) {
        int[] elf1Sections = Arrays.stream(elf1.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] elf2Sections = Arrays.stream(elf2.split("-")).mapToInt(Integer::parseInt).toArray();

        if ((elf1Sections[0] >= elf2Sections[0] && op.applyAsInt(elf1Sections[1], elf2Sections[1]) == 1)
            || (elf2Sections[0] >= elf1Sections[0] && op.applyAsInt(elf2Sections[1], elf1Sections[1]) == 1)) {
            return 1;
        }
        return 0;
    }

    private static void solvePartOne(List<String> input) {
        int fullyOverlappingPairs = 0;
        IntBinaryOperator comparison = (a,b) -> a <= b ? 1 : 0;

        for (String line : input) {
            String[] pair = line.split(",");
            fullyOverlappingPairs += checkOverlap(pair[0], pair[1], comparison);
        }
        System.out.println("Overlapping pairs: " + fullyOverlappingPairs);
    }

//    private static void solvePartTwo(List<String> input) {
//        int overlappingPairs = 0;
//
//        IntBinaryOperator comparison = (a,b) -> a <= b ? 1 : 0;
//
//        for (String line : input) {
//            String[] pair = line.split(",");
//            fullyOverlappingPairs += checkOverlap(pair[0], pair[1], comparison);
//        }
//        System.out.println("Overlapping pairs: " + fullyOverlappingPairs);
//    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        List<String> input = inputGetter.getPuzzleInputAsStringList("input/day04.in");

        solvePartOne(input);
    }
}
