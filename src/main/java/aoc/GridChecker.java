package aoc;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GridChecker {
    public IntGrid grid;
    enum Direction { UP, DOWN, LEFT, RIGHT}

    public GridChecker(IntGrid intGrid) {
        this.grid = intGrid;
    }

    public List<Direction> checkImmediateNeighboursLessThan(Point p) {
        List<Direction> shorterDirections = new ArrayList<>();
        int curPointValue = grid.get(p);

        if (grid.get(p.x - 1, p.y) < curPointValue) { // up neighbour
            shorterDirections.add(Direction.UP);
        }
        if (grid.get(p.x, p.y - 1) < curPointValue) { // left neighbour
            shorterDirections.add(Direction.LEFT);
        }
        if (grid.get(p.x, p.y + 1) < curPointValue) { // right neighbour
            shorterDirections.add(Direction.RIGHT);
        }
        if (grid.get(p.x + 1, p.y) < curPointValue) { // down neighbour
            shorterDirections.add(Direction.DOWN);
        }
        if (shorterDirections.isEmpty())
            return null;
        return shorterDirections;
    }

    public int checkDownLessThan(Point p, int startX) {
        for (int x = startX; x < grid.getNumRows(); x++) {
            if (grid.get(x, p.y) >= grid.get(p)) {
                return 0;
            }
        }
        return 1;
    }
    public int checkUpLessThan(Point p, int startX) {
        for (int x = startX; x >= 0; x--) {
            if (grid.get(x, p.y) >= grid.get(p)) {
                return 0;
            }
        }
        return 1;
    }
    public int checkLeftLessThan(Point p, int startY) {
        for (int y = startY; y >= 0; y--) {
            if (grid.get(p.x, y) >= grid.get(p)) {
                return 0;
            }
        }
        return 1;
    }

    public int checkRightLessThan(Point p, int startY) {
         for (int y = startY; y < grid.getNumCols(); y++) {
             if (grid.get(p.x, y) >= grid.get(p)) {
                return 0;
            }
        }
        return 1;
    }

    public int checkDirectionLessThan(Direction direction, Point p) {
        switch (direction) {
            case UP:
                return checkUpLessThan(p, p.x - 2);
            case DOWN:
                return checkDownLessThan(p, p.x + 2);
            case LEFT:
                return checkLeftLessThan(p, p.y - 2);
            case RIGHT:
                return checkRightLessThan(p, p.y + 2);
            default:
                return -1;
        }
    }
}
