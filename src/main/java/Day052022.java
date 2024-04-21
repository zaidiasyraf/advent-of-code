import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class Day052022 {

    public static void main(String[] args) {
        List<Stack<Character>> stacks = initStacks();
        List<Stack<Character>> stacks2 = initStacks();
        try (BufferedReader reader =  new BufferedReader(new FileReader("src/main/resources/Day052022.txt"))) {
            String line = reader.readLine();
            boolean facedBlank = false;
            while (line != null) {
                if (StringUtils.isBlank(line)) {
                    facedBlank = true;
                    line = reader.readLine();
                    continue;
                }
                if (!facedBlank) {
                    line = reader.readLine();
                    continue;
                }
                List<Integer> values = Arrays
                        .stream(line.split(" ")).filter(StringUtils::isNumeric).map(Integer::parseInt).collect(Collectors.toList());
                Stack<Character> from = stacks.get(values.get(1) - 1);
                Stack<Character> to = stacks.get(values.get(2) - 1);
                for (int i = values.get(0); i > 0; i--) {
                    to.push(from.pop());
                }
                // 2
                Stack<Character> from2 = stacks2.get(values.get(1) - 1);
                Stack<Character> to2 = stacks2.get(values.get(2) - 1);
                List<Character> temp = new ArrayList<>();
                for (int i = values.get(0); i > 0; i--) {
                    temp.add(from2.pop());
                }
                Collections.reverse(temp);
                for (Character c : temp) {
                    to2.push(c);
                }
                // read next line
                line = reader.readLine();
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Stack<Character> stack : stacks) {
                stringBuilder.append(stack.pop());
            }
            System.out.println("Result is " + stringBuilder);

            StringBuilder stringBuilder2 = new StringBuilder();
            for (Stack<Character> stack : stacks2) {
                stringBuilder2.append(stack.pop());
            }
            System.out.println("Result2 is " + stringBuilder2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Stack<Character>> initStacks() {
        List<Stack<Character>> stacks = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        stack.push('Q');
        stack.push('M');
        stack.push('G');
        stack.push('C');
        stack.push('L');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('R');
        stack.push('D');
        stack.push('L');
        stack.push('C');
        stack.push('T');
        stack.push('F');
        stack.push('H');
        stack.push('G');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('V');
        stack.push('J');
        stack.push('F');
        stack.push('N');
        stack.push('M');
        stack.push('T');
        stack.push('W');
        stack.push('R');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('J');
        stack.push('F');
        stack.push('D');
        stack.push('V');
        stack.push('Q');
        stack.push('P');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('N');
        stack.push('F');
        stack.push('M');
        stack.push('S');
        stack.push('L');
        stack.push('B');
        stack.push('T');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('R');
        stack.push('N');
        stack.push('V');
        stack.push('H');
        stack.push('C');
        stack.push('D');
        stack.push('P');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('H');
        stack.push('C');
        stack.push('T');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('G');
        stack.push('S');
        stack.push('J');
        stack.push('V');
        stack.push('Z');
        stack.push('N');
        stack.push('H');
        stack.push('P');
        stacks.add(stack);
        stack = new Stack<>();
        stack.push('Z');
        stack.push('F');
        stack.push('H');
        stack.push('G');
        stacks.add(stack);
        return stacks;
    }

}
