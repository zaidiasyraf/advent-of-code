import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class Day012022 {

    public static void main(String[] args) {
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day012022.txt"))) {
            String line = reader.readLine();
            int biggestTotalSoFar = 0;
            int secondBiggestTotalSoFar = 0;
            int thirdBiggestTotalSoFar = 0;
            int currentTotal = 0;
            while (line != null) {
                if (StringUtils.isNotBlank(line)) {
                    currentTotal = currentTotal + Integer.parseInt(line);
                }  else {
                    if (currentTotal > biggestTotalSoFar) {
                        thirdBiggestTotalSoFar = secondBiggestTotalSoFar;
                        secondBiggestTotalSoFar = biggestTotalSoFar;
                        biggestTotalSoFar = currentTotal;
                    } else if (currentTotal > secondBiggestTotalSoFar) {
                        thirdBiggestTotalSoFar = secondBiggestTotalSoFar;
                        secondBiggestTotalSoFar = currentTotal;
                    } else if (currentTotal > thirdBiggestTotalSoFar) {
                        thirdBiggestTotalSoFar = currentTotal;
                    }
                    currentTotal = 0;
                }
                // read next line
                line = reader.readLine();
            }
            System.out.println("Biggest calories = " + biggestTotalSoFar );
            System.out.println("Second biggest calories = " + secondBiggestTotalSoFar );
            System.out.println("Third biggest calories = " + thirdBiggestTotalSoFar );
            int totalTop3 = biggestTotalSoFar + secondBiggestTotalSoFar + thirdBiggestTotalSoFar;
            System.out.println("Total of top 3 biggest calories = " + totalTop3 );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
