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

    //{
    //https://neetcode.io/problems/generate-parentheses
    //28:35
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int closed = 0;
        StringBuilder stack = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        generateParenthesisBacktrack(open, closed, n, stack, result);
        return result;
    }
    public void generateParenthesisBacktrack(int open, int closed, int n, StringBuilder stack, ArrayList<String> result) {
        if (open == closed && open == n) {
            result.add(stack.toString());
            return;
        }

        if (open < n) {
            stack.append('(');
            generateParenthesisBacktrack(open+1, closed, n, stack, result);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closed < open) {
            stack.append(')');
            generateParenthesisBacktrack(open, closed+1, n, stack, result);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
    //}

    public int[] dailyTemperatures(int[] temperatures) {
        //https://neetcode.io/problems/daily-temperatures
        //45:22
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            result[i] = 0;
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] pair = stack.pop();
                int prevIndex = pair[1];
                result[prevIndex] = i - prevIndex;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        //https://neetcode.io/problems/car-fleet
        //58:36
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double slowestTime = 0;

        for (int[] p : pair) {
            double t = (double)(target - p[0]) / p[1];
            if (t > slowestTime) {
                fleets++;
                slowestTime = t;
            }
        }
        return fleets;
    }
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