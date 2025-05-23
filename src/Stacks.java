import java.io.*;
import java.util.*;

public class Stacks {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else if (map.containsValue(c)) {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
