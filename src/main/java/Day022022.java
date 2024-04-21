import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day022022 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A X", 3);
        map.put("A Y", 6);
        map.put("A Z", 0);
        map.put("B X", 0);
        map.put("B Y", 3);
        map.put("B Z", 6);
        map.put("C X", 6);
        map.put("C Y", 0);
        map.put("C Z", 3);

        int totalScore = 0;
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day022022.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                char lastChar = line.charAt(line.length() - 1);
                totalScore = totalScore + map.get(line) + getOurPoint(lastChar);
                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 1 total score: " + totalScore);

        Map<String, Character> map2 = new HashMap<>();
        map2.put("A X", 'Z');
        map2.put("A Y", 'X');
        map2.put("A Z", 'Y');
        map2.put("B X", 'X');
        map2.put("B Y", 'Y');
        map2.put("B Z", 'Z');
        map2.put("C X", 'Y');
        map2.put("C Y", 'Z');
        map2.put("C Z", 'X');

        int totalScore2 = 0;
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day022022.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                char lastChar = line.charAt(line.length() - 1);
                totalScore2 = totalScore2 + getMatchPoint(lastChar) + getOurPoint(map2.get(line));
                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 2 total score: " + totalScore2);
    }

    private static int getOurPoint (char c) {
        if (c == 'X') {
            return 1;
        } else if (c == 'Y') {
            return 2;
        } else {
            return 3;
        }
    }

    private static int getMatchPoint (char c) {
        if (c == 'X') {
            return 0;
        } else if (c == 'Y') {
            return 3;
        } else {
            return 6;
        }
    }

}
