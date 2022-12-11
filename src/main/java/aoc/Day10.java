package aoc;

import java.util.List;

public class Day10 {
    static int signalStrengthSum = 0;
    static int cycle = 0;
    static int x = 1;
    private static void runCycle() {
        cycle++;
        if (cycle == 20 || (cycle - 20) % 40 == 0) {
            System.out.println("On cycle " + cycle + " x is " + x);
            signalStrengthSum += cycle * x;
        }
    }
//    private static int checkCycle(int cycle, int x) {
//        if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140
//                || cycle == 180 || cycle == 220) {
////            System.out.println("On cycle " + cycle + " x is " + x);
//            return (cycle * x);
//        }
//        return 0;
//    }
    private static void solvePartOne(List<String> input) {
        for (String line : input) {
//            signalStrengthSum += checkCycle(cycle, x);
            if (line.contains("addx")) {
//                cycle++;
//                signalStrengthSum += checkCycle(cycle, x);
                runCycle();
                runCycle();
//                System.out.println(Integer.parseInt(line.split("addx ")[1]));
                x += Integer.parseInt(line.split("addx ")[1]);
            }
            else {
                runCycle();
            }
//            cycle++;
        }
        System.out.println("Sum of signal strength: " + signalStrengthSum);
    }
    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();
        List<String> input = inputGetter.getPuzzleInputAsStringList("input/day10.in");

        solvePartOne(input);
    }
}
