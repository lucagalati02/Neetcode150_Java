import java.io.*;
import java.util.*;

public class Arrays_N_Hashing {
    public boolean hasDuplicate(int[] nums) {
        //https://neetcode.io/problems/duplicate-integer
        //3:00
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        //https://neetcode.io/problems/is-anagram
        //3:31
        char[] s_a = s.toCharArray();
        char[] t_a = t.toCharArray();

        Arrays.sort(s_a);
        Arrays.sort(t_a);

        return Arrays.equals(s_a, t_a);
    }
}
