package aoc;

import java.util.List;

public class Day10 {
    private static int signalStrengthSum = 0;
    private static int cycle = 0;
    private static void runCycle(int x) {
        cycle++;
        if (cycle == 20 || (cycle - 20) % 40 == 0) {
            signalStrengthSum += cycle * x;
        }
    }
    private static void solvePartOne(List<String> input) {
        int x = 1;

        for (String line : input) {
            if (line.contains("addx")) {
                runCycle(x);
                runCycle(x);
                x += Integer.parseInt(line.split("addx ")[1]);
            }
            else { // if noop
                runCycle(x);
            }
        }
        System.out.println("Sum of signal strength: " + signalStrengthSum);
    }
    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        List<String> input = inputGetter.getPuzzleInputAsStringList("input/day10.in");

        solvePartOne(input);
    }
}
