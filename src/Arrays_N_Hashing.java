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

    public int[] twoSum(int[] nums, int target) {
        //https://neetcode.io/problems/two-integer-sum
        //13:13
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = {};

        for (int i = 0; i < nums.length; i++) {
            int desire = target - nums[i];

            if (map.containsKey(desire)) {
                ans =  new int[] {map.get(desire), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
