import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day032023 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Day032023.txt"))) {
            long rows = reader.lines().count();
            String line = reader.readLine();
            String[][] plane = new String[Math.toIntExact(rows)][line.length()];
            int totalAnswer1 = 0;
            int totalAnswer2 = 0;
            while (line != null) {

                // read next line
                line = reader.readLine();
            }
            System.out.println("Answer 1 : " + totalAnswer1);
            System.out.println("Answer 2 : " + totalAnswer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
