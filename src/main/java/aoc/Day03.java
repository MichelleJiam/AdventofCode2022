package aoc;

import java.util.List;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Day03 {
    public static int calculatePriority(Character duplicate) {
        if (Character.isUpperCase(duplicate)) {
            return (Character.compare(duplicate, 'A') + 27);
        }
        else {
            return (Character.compare(duplicate, 'a') + 1);
        }
    }

    private static HashSet<Character> makeSetFromString(String string) {
        HashSet<Character> set = string.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.toCollection(HashSet::new));
        return set;
    }

    private static Character findDuplicate(String s1, String s2, String s3) {
        HashSet<Character> h1 = makeSetFromString(s1);
        HashSet<Character> h2 = makeSetFromString(s2);
        HashSet<Character> h3 = s3 != null ? makeSetFromString(s3) : null;

        h1.retainAll(h2); // reduce set to only duplicates
        if (h3 != null) {
            h1.retainAll(h3); // further reduce if comparing 3 strings
        }
        return h1.stream().findFirst().get();
    }

    private static void solvePartTwo(List<String> input) {
        int prioritySum = 0;

        for (int i = 0; i < input.size(); i += 3) {
            Character duplicate = findDuplicate(input.get(i), input.get(i + 1), input.get(i + 2));
            prioritySum += calculatePriority(duplicate);
        }
        System.out.println("Sum of priorities: " + prioritySum);
    }

    private static void solvePartOne(List<String> input) {
        int prioritySum = 0;

        for (String line : input) {
            String s1 = line.substring(0, line.length() / 2);
            String s2 = line.substring(line.length() / 2);
            Character duplicate = findDuplicate(s1, s2, null);
            prioritySum += calculatePriority(duplicate);
        }
        System.out.println("Sum of priorities: " + prioritySum);
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        List<String> input = inputGetter.getPuzzleInputAsStringList("input/day03.in");
        if (input == null)
            System.exit(1);

        solvePartOne(input);
        solvePartTwo(input);
    }
}
