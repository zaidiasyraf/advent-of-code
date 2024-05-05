import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class Day022023 {

    private static final int RED_LIMIT = 12;
    private static final int GREEN_LIMIT = 13;
    private static final int BLUE_LIMIT = 14;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Day022023.txt"))) {
            String line = reader.readLine();
            int totalAnswer1 = 0;
            int totalAnswer2 = 0;
            while (line != null) {
                line = StringUtils.deleteWhitespace(line);
                String[] splitColon = line.split(":");
                int currentGame = Integer.parseInt(splitColon[0].replace("Game", ""));

                String[] splitSemiColon = splitColon[1].split(";");
                totalAnswer1 = firstQuestionLogic(currentGame, totalAnswer1, splitSemiColon);
                totalAnswer2 = secondQuestionLogic(totalAnswer2, splitSemiColon);

                // read next line
                line = reader.readLine();
            }
            System.out.println("Answer 1 : " + totalAnswer1);
            System.out.println("Answer 2 : " + totalAnswer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum COLOUR {
        BLUE,
        RED,
        GREEN
    }

    private static int firstQuestionLogic(int currentGame, int totalAnswer1, String[] splitSemiColon) {
        try {
            for (String semiColon : splitSemiColon) {
                String[] splitComma = semiColon.split(",");
                for (String comma : splitComma) {
                    if (comma.contains(COLOUR.BLUE
                            .name()
                            .toLowerCase(Locale.ROOT))) {
                        int ballCount = Integer.parseInt(comma.replace(COLOUR.BLUE
                                .name()
                                .toLowerCase(Locale.ROOT), ""));
                        if (ballCount > BLUE_LIMIT) {
                            throw new IllegalStateException("Wrong");
                        }
                        continue;
                    } else if (comma.contains(COLOUR.RED
                            .name()
                            .toLowerCase(Locale.ROOT))) {
                        int ballCount = Integer.parseInt(comma.replace(COLOUR.RED
                                .name()
                                .toLowerCase(Locale.ROOT), ""));
                        if (ballCount > RED_LIMIT) {
                            throw new IllegalStateException("Wrong");
                        }
                        continue;
                    } else if (comma.contains(COLOUR.GREEN
                            .name()
                            .toLowerCase(Locale.ROOT))) {
                        int ballCount = Integer.parseInt(comma.replace(COLOUR.GREEN
                                .name()
                                .toLowerCase(Locale.ROOT), ""));
                        if (ballCount > GREEN_LIMIT) {
                            throw new IllegalStateException("Wrong");
                        }
                        continue;
                    }
                    throw new IllegalStateException("weird");
                }
            }
            return totalAnswer1 + currentGame;
        } catch (IllegalStateException e) {
            System.out.println(currentGame + " is not possible");
        }
        return totalAnswer1;
    }

    private static int secondQuestionLogic(int totalAnswer2, String[] splitSemiColon) {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;
        for (String semiColon : splitSemiColon) {
            String[] splitComma = semiColon.split(",");
            for (String comma : splitComma) {
                if (comma.contains(COLOUR.BLUE
                        .name()
                        .toLowerCase(Locale.ROOT))) {
                    int ballCount = Integer.parseInt(comma.replace(COLOUR.BLUE
                            .name()
                            .toLowerCase(Locale.ROOT), ""));
                    if (ballCount > maxBlue) {
                        maxBlue = ballCount;
                    }
                    continue;
                } else if (comma.contains(COLOUR.RED
                        .name()
                        .toLowerCase(Locale.ROOT))) {
                    int ballCount = Integer.parseInt(comma.replace(COLOUR.RED
                            .name()
                            .toLowerCase(Locale.ROOT), ""));
                    if (ballCount > maxRed) {
                        maxRed = ballCount;
                    }
                    continue;
                } else if (comma.contains(COLOUR.GREEN
                        .name()
                        .toLowerCase(Locale.ROOT))) {
                    int ballCount = Integer.parseInt(comma.replace(COLOUR.GREEN
                            .name()
                            .toLowerCase(Locale.ROOT), ""));
                    if (ballCount > maxGreen) {
                        maxGreen = ballCount;
                    }
                    continue;
                }
                throw new IllegalStateException("weird");
            }
        }
        int total = maxRed * maxGreen * maxBlue;
        return totalAnswer2 + total;
    }

}
