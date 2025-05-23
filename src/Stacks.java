import java.io.*;
import java.util.*;

public class Stacks {
    public boolean isValid(String s) {
        //https://neetcode.io/problems/validate-parentheses
        //34:57
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // c is a closing bracket
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // c is (presumably) an opening bracket
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
