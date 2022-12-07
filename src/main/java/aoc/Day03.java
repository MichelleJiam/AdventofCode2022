package aoc;

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Day03 {
    public static int calculatePriority(Character duplicate) {
        if (Character.isUpperCase(duplicate)) {
            return (Character.compare(duplicate, 'A') + 27);
        }
        else {
            return (Character.compare(duplicate, 'a') + 1);
        }
    }

    private static void solvePartTwo(Scanner input) {
        int prioritySum = 0;
        ArrayList< HashSet<Character> > sacks = new ArrayList<>();
        sacks.add(new HashSet<Character>()); sacks.add(new HashSet<Character>()); sacks.add(new HashSet<Character>());
        int elf = 0;
        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            for(int i = 0; i < currentLine.length(); i++) {
                sacks.get(elf).add(currentLine.charAt(i));
            }
            if (elf == 2) {
                sacks.get(0).retainAll(sacks.get(1));
                sacks.get(2).retainAll(sacks.get(0));
                Character dup = sacks.get(2).stream().findFirst().get();
                prioritySum += calculatePriority(dup);
                for(HashSet sack : sacks) {
                    sack.clear();
                }
                elf = 0;
            }
            else {
                elf++;
            }
        }
        System.out.println("Sum of priorities: " + prioritySum);
    }

    private static void solvePartOne(Scanner input) {
        int prioritySum = 0;

        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
            for(int i = 0; i < currentLine.length()/2; i++) {
                h1.add(currentLine.charAt(i));
            }
            for(int i = currentLine.length()/2; i < currentLine.length(); i++) {
                h2.add(currentLine.charAt(i));
            }
            h1.retainAll(h2);
            Character dup = h1.stream().findFirst().get();

            prioritySum += calculatePriority(dup);
        }
        System.out.println("Sum of priorities: " + prioritySum);
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        solvePartOne(inputGetter.getPuzzleInputAsScanner("input/day03.in"));
        solvePartTwo(inputGetter.getPuzzleInputAsScanner("input/day03.in"));
    }
}
