package aoc;

import java.awt.*;
import java.util.List;
import aoc.GridChecker.Direction;

public class Day08 {
    private static void solvePartTwo(IntGrid input) {

    }

    private static int  checkVisibility(Point p, GridChecker gridChecker) {
        // if immediate neighbours are tall enough, no need to check others
        List<Direction> directionsToCheck = gridChecker.checkImmediateNeighboursLessThan(p);
        if (directionsToCheck == null)
            return 0;

        for (Direction direction : directionsToCheck) {
            if (gridChecker.checkDirectionLessThan(direction, p) == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static void solvePartOne(IntGrid input) {
        GridChecker gridChecker = new GridChecker(input);
        int edgeVisibleTrees = input.getNumRows() * 2 + input.getNumCols() * 2 - 4;
        int innerVisibleTrees = 0;

        // skipping the first and last rows and columns
        for (int row = 1; row < input.getNumRows() - 1; row++) {
            for (int col = 1; col < input.getNumCols() - 1; col++) {
                innerVisibleTrees += checkVisibility(new Point(row, col), gridChecker);
            }
        }
        System.out.println("Number of visible trees: " + (edgeVisibleTrees + innerVisibleTrees));
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        IntGrid input = new IntGrid(inputGetter.getPuzzleInputAsIntArrayList("input/day08.in"));
        if (input == null)
            System.exit(1);

        solvePartOne(input);
//        solvePartTwo(input);
    }
}
