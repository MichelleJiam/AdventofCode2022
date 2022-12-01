package aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 {
    private static void solvePuzzle(Scanner input) {
        ArrayList<Integer> calorieTotals = new ArrayList<Integer>();
        int currentCalorieTotal = 0;

        while (input.hasNextLine()) {
            String currentLine = input.nextLine();
            if (currentLine.length() == 0) { // if end of current elf inventory
                calorieTotals.add(currentCalorieTotal);
                currentCalorieTotal = 0;
            } else {
                currentCalorieTotal += Integer.parseInt(currentLine);
            }
            if (!input.hasNext()) { // last line of input
                calorieTotals.add(currentCalorieTotal);
            }
        }

        Collections.sort(calorieTotals, Collections.reverseOrder());
        System.out.println("Single most calories are: " + calorieTotals.get(0));

        int topThreeTotals = calorieTotals.stream().mapToInt(Integer::intValue).limit(3).sum();
        System.out.println("Three most calories are: " + topThreeTotals);
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        Scanner input = inputGetter.getPuzzleInputAsScanner("input/day01.in");
        solvePuzzle(input);
        input.close();
    }
}
