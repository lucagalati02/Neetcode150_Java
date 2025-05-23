import java.io.*;
import java.util.*;

public class Stacks {
    public boolean isValid(String s) {
        //https://neetcode.io/problems/validate-parentheses
        //23:36
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

    //{
    //https://neetcode.io/problems/evaluate-reverse-polish-notation
    //27:33
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int res;
                switch (token) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    default: res = a / b;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //}

    
}

//{
//https://neetcode.io/problems/minimum-stack
//22:56
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
//}