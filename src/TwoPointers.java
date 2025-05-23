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

    public int[] twoSum(int[] numbers, int target) {
        //https://neetcode.io/problems/two-integer-sum-ii
        //5:25
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            int current = numbers[left] + numbers[right];
            if (current < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[] {left+1, right+1};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //https://neetcode.io/problems/three-integer-sum
        //16:22
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            // skip duplicates for the “first” element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip duplicates on left and right
                    while (left < right && nums[left] == nums[left + 1])  left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;
                }
                else {  // sum > target
                    right--;
                }
            }
        }

        return res;
    }

    public int maxArea(int[] heights) {
        //https://neetcode.io/problems/max-water-container
        //25:00
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, area);

            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}
