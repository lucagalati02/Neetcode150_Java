import java.io.*;
import java.util.*;

public class BackTracking {
    //{
    //https://neetcode.io/problems/subsets
    //43:02
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subsetsHelper(nums, 0, subset, result);
        return result;
    }

    void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        subsetsHelper(nums, i+1, subset, res);
        subset.remove(subset.size() - 1);
        subsetsHelper(nums, i+1, subset, res);
    }
    //}
}
