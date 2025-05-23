import java.io.*;
import java.util.*;
public class SlidingWindow {
    public int maxProfit(int[] prices) {
        //https://neetcode.io/problems/buy-and-sell-crypto
        //14:56
        int left = 0;            // potential buy day
        int maxProfit = 0;

        // try selling on every later day
        for (int right = 1; right < prices.length; right++) {
            int profit = prices[right] - prices[left];
            maxProfit = Math.max(profit, maxProfit);
            // if today’s price is lower than your current buy, reset buy here
            if (prices[right] < prices[left]) {
                left = right;
            }
        }

        return maxProfit;
    }

    public int lengthOfLongestSubstring(String s) {
        //https://neetcode.io/problems/longest-substring-without-duplicates
        //45:07
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int characterReplacement(String s, int k) {
        //D.N.C.
    }
}
