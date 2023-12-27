package com.wl.trees;


public class SubtreeOfAnotherTree_572 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(new SubtreeOfAnotherTree_572().isSubtree(root, subRoot));
        //System.out.println(new SubtreeOfAnotherTree_572().checkValues(root.left,subRoot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return checkValues(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkValues(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        boolean leftCheck = checkValues(root1.left, root2.left);
        boolean rightCheck = checkValues(root1.right, root2.right);
        return leftCheck && rightCheck;
    }
}
