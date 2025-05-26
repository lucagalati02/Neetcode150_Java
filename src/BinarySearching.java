public class BinarySearching {
    //https://neetcode.io/problems/binary-search
    //7:34
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            }
            else if (target > nums[mid]) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //https://neetcode.io/problems/search-2d-matrix
        //37:23
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (target < matrix[mid][0]) {
                bottom = mid - 1;
            }
            else if (target > matrix[mid][0]) {
                top = mid + 1;
            }
            else {
                return true;
            }
        }

        if (bottom < 0) {
            return false;
        }
        int row = bottom;

        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < matrix[row][mid]) {
                right = mid - 1;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
