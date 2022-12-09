package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

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

    public List<int[]> getPuzzleInputAsIntArrayList(String filePath, String numberDelimiter) {
        List<String> stringList = getPuzzleInputAsStringList(filePath);
        if (stringList == null)
                return null;

        List<int[]> intList = new ArrayList<int[]>(stringList.size());
        for (String line : stringList) {
            int[] array = Stream.of(line.split(numberDelimiter)).mapToInt(Integer::parseInt).toArray();
            intList.add(array);
        }
        return intList;
    }
}
