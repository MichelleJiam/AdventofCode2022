package aoc;

import java.awt.*;
import java.util.List;

public class IntGrid {
    public List<int[]> grid;

    public IntGrid(List<int[]> grid) {
        this.grid = grid;
    }

    public int getNumCols() {
        return grid.get(0).length;
    }

    public int getNumRows() {
        return grid.size();
    }

    public int get(Point coord) {
        if (coord.x >= 0 && coord.x < grid.size()
                && coord.y >= 0 && coord.y < grid.get(0).length) {
            return grid.get(coord.x)[coord.y];
        }
        return -1;
    }

    public int get(int x, int y) {
        return get(new Point(x, y));
    }
}
