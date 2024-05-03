import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day012023 {

    public static void main(String[] args) {
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day012023.txt"))) {
            String line = reader.readLine();
            int answer1 = 0;
            int answer2 = 0;
            while (line != null) {
                String numberString1 = "";
                String numberString2 = "";
                // Key = index, value = number
                Map<Integer, Integer> indexNumberMap = new HashMap<>();
                char[] chars = line.toCharArray();
                for (char c : chars) {
                    if (Character.isDigit(c)) {
                        numberString1 = numberString1 + c;
                        break;
                    }
                }
                for (int i = 0; i < chars.length; i++)  {
                    if (Character.isDigit(chars[i])) {
                        indexNumberMap.put(i, Character.getNumericValue(chars[i]));
                    }
                }

                for (NUMBER number : NUMBER.values()) {
                    if (line.contains(number.name().toLowerCase())) {
                        int index = line.indexOf(number
                                .name()
                                .toLowerCase());
                        indexNumberMap.put(index, getNumberValue(number));
                        while (index >= 0) {
                            index = line.indexOf(number.name().toLowerCase(), index + 1);
                            if (index >= 0) {
                                indexNumberMap.put(index, getNumberValue(number));
                            }
                        }
                    }
                }
                Integer lowestIndex = indexNumberMap.keySet().stream().min(Integer::compareTo).get();


                String lineReverse = new StringBuilder(line).reverse().toString();
                chars = lineReverse.toCharArray();
                for (char c : chars) {
                    if (Character.isDigit(c)) {
                        numberString1 = numberString1 + c;
                        break;
                    }
                }
                Integer highestIndex = indexNumberMap.keySet().stream().max(Integer::compareTo).get();
                numberString2 = indexNumberMap.get(lowestIndex).toString() + indexNumberMap.get(highestIndex).toString();

                answer1 = answer1 + Integer.parseInt(numberString1);
                answer2 = answer2 + Integer.parseInt(numberString2);

                // read next line
                line = reader.readLine();
            }
            System.out.println("Answer 1 : " + answer1);
            System.out.println("Answer 2 : " + answer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum NUMBER {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE
    }

    private static int getNumberValue(NUMBER number) {
        return switch (number) {
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
        };
    }

}
