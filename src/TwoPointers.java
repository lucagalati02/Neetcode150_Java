import java.io.*;
import java.util.*;

public class TwoPointers {
    public boolean isPalindrome(String s) {
        //https://neetcode.io/problems/is-palindrome
        //17:42
        char[] w = s.toCharArray();
        int l = 0;
        int r = w.length - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
