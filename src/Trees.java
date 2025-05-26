public class Trees {
    TreeNode invertTree(TreeNode root) {
        //https://neetcode.io/problems/invert-a-binary-tree
        //6:17
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    int maxDepth(TreeNode root) {
        //https://neetcode.io/problems/depth-of-binary-tree
        //4:07
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //{
    //https://neetcode.io/problems/binary-tree-diameter
    //8:23
    int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }
    //}

    //{
    //https://neetcode.io/problems/balanced-binary-tree
    //6:19
    boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) &&
                (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};
    }
    //}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}