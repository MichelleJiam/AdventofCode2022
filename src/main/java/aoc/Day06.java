package aoc;

public class Day06 {
    private static void solvePuzzle(String input, int markerLength) {
        for (int i = 0; i < input.length(); i++) {
            String substring = "";
            for (int j = i; j < i + markerLength; j++) {
                Character curChar = input.charAt(j);
                if (substring.contains(Character.toString(curChar))) {
                    break;
                } else {
                    substring += curChar;
                    if (substring.length() == markerLength) {
                        System.out.println("Marker found at index " + (j + 1));
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        InputGetter inputGetter = new InputGetter();

        String input = inputGetter.getPuzzleInputAsString("input/day06.in");
        solvePuzzle(input, 4); // part 1
        solvePuzzle(input, 14); // part 2
    }
}
