package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputGetter {
    public Scanner getPuzzleInputAsScanner(String filePath) {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file");
        }
        return fileReader;
    }

    public String getPuzzleInput(Path filePath) throws IOException {
        return Files.readString(filePath);
    }
}
