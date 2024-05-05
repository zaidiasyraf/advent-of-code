import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class Day022023 {

    public static void main(String[] args) {
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day022023.txt"))) {
            String line = reader.readLine();
            int redLimit = 12;
            int greenLimit = 13;
            int blueLimit = 14;
            int totalAnswer1 = 0;
            while (line != null) {
                line = StringUtils.deleteWhitespace(line);
                String[] splitColon = line.split(":");
                int currentGame = Integer.parseInt(splitColon[0].replace("Game", ""));

                String[] splitSemiColon = splitColon[1].split(";");
                int blueCount = 0;
                int redCount = 0;
                int greenCount = 0;
                for (String semiColon : splitSemiColon) {
                    String[] splitComma = semiColon.split(",");
                    for (String comma : splitComma) {
                        if (comma.contains(COLOUR.BLUE.name().toLowerCase(Locale.ROOT))) {
                            blueCount = blueCount + Integer.parseInt(comma.replace(COLOUR.BLUE.name().toLowerCase(Locale.ROOT), ""));
                            continue;
                        } else if (comma.contains(COLOUR.RED.name().toLowerCase(Locale.ROOT))) {
                            redCount = redCount + Integer.parseInt(comma.replace(COLOUR.RED.name().toLowerCase(Locale.ROOT), ""));
                            continue;
                        } else if (comma.contains(COLOUR.GREEN.name().toLowerCase(Locale.ROOT))) {
                            greenCount = greenCount + Integer.parseInt(comma.replace(COLOUR.GREEN.name().toLowerCase(Locale.ROOT), ""));
                            continue;
                        }
                        throw new IllegalStateException("weird");
                    }
                }
                if (blueCount <= blueLimit && redCount <= redLimit && greenCount <= greenLimit) {
                    totalAnswer1 = totalAnswer1 + currentGame;
                }

                // read next line
                line = reader.readLine();
            }
            System.out.println("Answer 1 : " + totalAnswer1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum COLOUR {
        BLUE,
        RED,
        GREEN
    }

}
