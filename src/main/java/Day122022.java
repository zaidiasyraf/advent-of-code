import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day122022 {

    static String input = """
            Sabqponm
            abcryxxl
            accszExk
            acctuvwj
            abdefghi
            """;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> lines = input.lines().toList();
        final int x = lines.get(0).length();
        final int y = lines.size();

        Coordinate target = null;

        char[][] plane = new char[y][x];
        for (int i = 0; i < y; i ++) {
            for (int j = 0; j < x; j++) {
                plane[i][j] = lines.get(i).charAt(j);
                if (plane[i][j] == 'E') {
                    target = new Coordinate(j, i);
                }
            }
        }

        char[][] answer = new char[y][x];
        for (char[] row : answer) {
            Arrays.fill(row, '.');
        }

        loop:
        for (int i = 0; i < y; ) {
            for (int j = 0; j < x;) {
                char c = plane[i][j];
                if (c == 'E') {
                    break loop;
                }

                List<Coordinate> possibleMove = new ArrayList<>();
                // up
                int up = i - 1;
                if (up >= 0) {
                    char c2 = plane[up][j];
                    if (Character.compare(c, c2) <= 0) {
                        possibleMove.add(new Coordinate(j, up));
                    }
                }

                // down
                int down = i + 1;
                if (down <= y) {
                    char c2 = plane[down][j];
                    if (Character.compare(c, c2) <= 0) {
                        possibleMove.add(new Coordinate(j, down));
                    }
                }

                // left
                int left = j - 1;
                if (left >= 0) {
                    char c2 = plane[i][left];
                    if (Character.compare(c, c2) <= 0) {
                        possibleMove.add(new Coordinate(left, j));

                    }

                }

                // right
                int right = j + 1;
                if (right <= x) {
                    char c2 = plane[i][right];
                    if (Character.compare(c, c2) <= 0) {
                        possibleMove.add(new Coordinate(right, i));
                    }
                }

                if (possibleMove.size() == 1) {
                    printDirection(answer, j, i, possibleMove.get(0).x, possibleMove.get(0).y);
                    i = possibleMove.get(0).y;
                    j = possibleMove.get(0).x;
                    continue;
                }

                Coordinate closest = new Coordinate(j, i).getTheClosestCoordinate(possibleMove, plane);
                printDirection(answer, j, i, closest.x, closest.y);
                i = closest.y;
                j = closest.x;
                int g = 0;
            }
        }
        int k = 0;
    }

    private static void printDirection(char[][] canvas, int currX, int currY, int nextX, int nextY){
        if (currX - nextX == 0) {
            if (currY - nextY == 1 ) {
                canvas[currY][currX] = '^';
            } else {
                canvas[currY][currX] = 'V';
            }
        } else {
            if (currX - nextX == 1) {
                canvas[currY][currX] = '<';
            } else {
                canvas[currY][currX] = '>';
            }
        }
    }

    record Coordinate(int x, int y) {

        public double calculateDistance(Coordinate coordinate) {
            int x2 = x - coordinate.x;
            int y2 = y - coordinate.y;
            return Math.sqrt((x2 * x2) + (y2 * y2));
        }

        public Coordinate getTheClosestCoordinate(List<Coordinate> coordinates, char[][] plane) {
            // TODO: take into account the char as well
            double lowestDistance = 0;
            Coordinate closest = null;
            char currentChar = 'a';
            for (Coordinate coordinate : coordinates) {
                if (lowestDistance == 0) {
                    lowestDistance = calculateDistance(coordinate);
                    closest = coordinate;
                    currentChar = plane[coordinate.y][coordinate.x];
                    continue;
                }

                double distance = calculateDistance(coordinate);
                char c = plane[coordinate.y][coordinate.x];
                // TODO: this is the last changes
                if (distance <= lowestDistance && c - currentChar == 1 ) {
                    lowestDistance = distance;
                    closest = coordinate;
                    currentChar = c;
                }
            }
            return closest;
        }

    }

}
