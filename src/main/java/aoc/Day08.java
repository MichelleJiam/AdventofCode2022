package aoc;

import java.util.ArrayList;
import java.util.List;

public class Day08 {
    private static List<int[]> input;
    private static int numRows, numCols;

    enum Neighbour { UP, DOWN, LEFT, RIGHT}

    private static List<Neighbour> findShorterImmediateNeighbour(int row, int col) {
        int curHeight = input.get(row)[col];
        List<Neighbour> shorterNeighbours = new ArrayList<Neighbour>();

        if (input.get(row - 1)[col] < curHeight) { // up neighbour
            shorterNeighbours.add(Neighbour.UP);
        }
        if (input.get(row)[col - 1] < curHeight) { // left neighbour
            shorterNeighbours.add(Neighbour.LEFT);
        }
        if (input.get(row)[col + 1] < curHeight) { // right neighbour
            shorterNeighbours.add(Neighbour.RIGHT);
        }
        if (input.get(row + 1)[col] < curHeight) { // down neighbour
            shorterNeighbours.add(Neighbour.DOWN);
        }
        if (shorterNeighbours.isEmpty())
            return null;
        return shorterNeighbours;
    }

    private static int checkDown(int row, int col) {
        int curHeight = input.get(row)[col];

        for (int r = row + 2; r < numRows; r++) {
//            System.out.println("Checking neighbour " + r + ", " + col + " | height: " + input.get(r)[col]);
            if (input.get(r)[col] >= curHeight) {
//                System.out.println("Taller neighbour found");
                return 0;
            }
        }
//        if (row <)
//        System.out.println("Tree is visible from below");
        return 1;
    }

    private static int checkUp(int row, int col) {
        int curHeight = input.get(row)[col];

        for (int r = row - 2; r >= 0; r--) {
            if (input.get(r)[col] >= curHeight) {
                return 0;
            }
        }
//        System.out.println("Tree is visible from above");
        return 1;
    }

    private static int checkLeft(int row, int col) {
        int curHeight = input.get(row)[col];

        for (int c = col - 2; c >= 0; c--) {
            if (input.get(row)[c] >= curHeight) {
                return 0;
            }
        }
//        System.out.println("Tree is visible from left");
        return 1;
    }

    private static int checkRight(int row, int col) {
        int curHeight = input.get(row)[col];

        for (int c = col + 2; c < numCols; c++) {
            if (input.get(row)[c] >= curHeight) {
                return 0;
            }
        }
//        System.out.println("Tree is visible from right");
        return 1;
    }

    private static int  checkVisibility(int row, int col) {
        // if immediate neighbours are tall enough, no need to check others
        List<Neighbour> directionsToCheck = findShorterImmediateNeighbour(row, col);
        if (directionsToCheck == null)
            return 0;

        for (Neighbour direction : directionsToCheck) {
            if (direction == Neighbour.UP && checkUp(row, col) == 1) {
                return 1;
            }
            if (direction == Neighbour.DOWN && checkDown(row, col) == 1) {
                return 1;
            }
            if (direction == Neighbour.LEFT && checkLeft(row, col) == 1) {
                return 1;
            }
            if (direction == Neighbour.RIGHT && checkRight(row, col) == 1) {
                return 1;
            }
        }
        return 0;
    }

    private static void solvePartTwo() {

    }

    private static void solvePartOne() {
        int edgeVisibleTrees = (input.size() * 2) + (input.get(0).length * 2) - 4;
        System.out.println(input.size() + " " + input.get(0).length);
        int innerVisibleTrees = 0;

        // memoization attempt
//        List<Integer> colValues = new ArrayList<Integer>(input.size());
//        List<Integer> rowValues = new ArrayList<Integer>(input.get(0).length);

        // skipping the first and last rows and columns
        for (int row = 1; row < numRows - 1; row++) {
            for (int col = 1; col < numCols - 1; col++) {
                innerVisibleTrees += checkVisibility(row, col);
            }
        }
        System.out.println("Number of visible trees: " + edgeVisibleTrees + " + " + innerVisibleTrees);
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        input = inputGetter.getPuzzleInputAsIntArrayList("input/day08.in");
        if (input == null)
            System.exit(1);

        numRows = input.size();
        numCols = input.get(0).length;
        solvePartOne();
//        solvePartTwo();
    }
}
