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

    public List<List<String>> groupAnagrams(String[] strs) {
        //https://neetcode.io/problems/anagram-groups
        //24:02
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s_temp = Arrays.toString(temp);

            if (map.containsKey(s_temp)) {
                ArrayList<String> new_arr = map.get(s_temp);
                new_arr.add(str);
            } else {
                ArrayList<String> new_arr = new ArrayList<>();
                new_arr.add(str);
                map.put(s_temp, new_arr);
            }
        }
        return new ArrayList<>(map.values());
    }

    public int[] topKFrequent(int[] nums, int k) {
        //https://neetcode.io/problems/top-k-elements-in-list
        //45:00
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            if (map.containsKey(num)) {
                int pointer = map.get(num);
                pointer++;
                map.put(num, pointer);
            }
            else {
                map.put(num, 1);
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }

    //{
    //https://neetcode.io/problems/string-encode-and-decode
    //36:23
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length())
                    .append('#')
                    .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            // find the '#' that separates the length prefix
            int j = s.indexOf('#', i);
            int len = Integer.parseInt(s.substring(i, j));
            // extract the next 'len' characters as the string
            String str = s.substring(j + 1, j + 1 + len);
            res.add(str);
            // move past this entry
            i = j + 1 + len;
        }
        return res;
    }
    //}

    public int[] productExceptSelf(int[] nums) {
        //https://neetcode.io/problems/products-of-array-discluding-self
        //44:58
        int[] output = new int[nums.length];

        //prefix
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= postfix;
            postfix *= nums[i];
        }
        return output;
    }

    public boolean isValidSudoku(char[][] board) {
        //D.N.C.
    }

    public int longestConsecutive(int[] nums) {
        //https://neetcode.io/problems/longest-consecutive-sequence
        //25:04
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        int longest = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int length = 1;
                while (numSet.contains(n + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
