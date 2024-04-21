import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day042022 {

    public static void main (String[] args) {
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day042022.txt"))) {
            String line = reader.readLine();
            int totalDuplicate = 0;
            int totalDuplicate2 = 0;
            while (line != null) {
                String[] ranges = line.split(",");
                List<Integer> firstNumbers = generateIntegers(ranges[0]);
                List<Integer> secondNumbers = generateIntegers(ranges[1]);
                if (firstNumbers.size() > secondNumbers.size()) {
                    if (firstNumbers.containsAll(secondNumbers)) {
                        totalDuplicate = totalDuplicate + 1;
                    }
                    if (secondNumbers.stream().anyMatch(k -> firstNumbers.contains(k))) {
                        totalDuplicate2 = totalDuplicate2 + 1;
                    }
                } else {
                    if (secondNumbers.containsAll(firstNumbers)) {
                        totalDuplicate = totalDuplicate + 1;
                    }
                    if (firstNumbers.stream().anyMatch(k -> secondNumbers.contains(k))) {
                        totalDuplicate2 = totalDuplicate2 + 1;
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Total duplicate : " + totalDuplicate);
            System.out.println("Total duplicate at least once : " + totalDuplicate2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> generateIntegers (String range) {
        String[] lowerUpperLimit = range.split("-");
        List<Integer> numbers = new ArrayList<>();
        for (int i = Integer.parseInt(lowerUpperLimit[0]); i <= Integer.parseInt(lowerUpperLimit[1]); i++) {
            numbers.add(i);
        }
        return numbers;
    }

}
