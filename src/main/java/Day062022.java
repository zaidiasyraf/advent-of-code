import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day062022 {

    public static void main(String[] args) {

        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day062022.txt"))) {
            String line = reader.readLine();
            Set<Character> set = new HashSet<>();
            char[] chars = line.toCharArray();
            for (int i = 0; i <= chars.length ; i++) {
                set.add(chars[i]);
                for (int k = i + 1; k <= chars.length ; k++) {
                    if (set.size() == 14) {
                        System.out.println("Value = " + k);
                        return;
                    }
                    if (!set.add(chars[k])) {
                        break;
                    }
                }
                set.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
