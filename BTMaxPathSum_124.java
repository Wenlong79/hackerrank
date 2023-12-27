package com.wl.trees;

public class BTMaxPathSum_124 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxPathSum(node));
    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        max = Math.max(max, left + right + node.val);
        return Math.max(left + node.val, right + node.val);
    }
}
