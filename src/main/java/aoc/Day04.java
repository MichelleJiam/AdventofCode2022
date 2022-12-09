package aoc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day04 {
    private static int checkOverlap(String elf1, String elf2) {
        int[] elf1Sections = Arrays.stream(elf1.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] elf2Sections = Arrays.stream(elf2.split("-")).mapToInt(Integer::parseInt).toArray();

        if (elf1Sections[0] > elf2Sections[0]) {
            if (elf1Sections[1] <= elf2Sections[1]) {
                return 1;
            } else return 0;
        }
        else {
            if (elf2Sections[1] <= elf1Sections[1])
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        List<String> input = inputGetter.getPuzzleInputAsStringList("input/day04.in");
        int overlappingPairs = 0;

        for (String line : input) {
            String[] pair = line.split(",");
            overlappingPairs += checkOverlap(pair[0], pair[1]);
        }
        System.out.println("Overlapping pairs: " + overlappingPairs);
    }
}
