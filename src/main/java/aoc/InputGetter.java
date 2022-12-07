package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class InputGetter {
    public Scanner getPuzzleInputAsScanner(String filePath) {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }

    public String getPuzzleInputAsString(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getPuzzleInputAsStringList(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
