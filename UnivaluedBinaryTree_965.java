package com.wl.trees;

public class UnivaluedBinaryTree_965 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(3, null, new TreeNode(3)), new TreeNode(3));
        System.out.println(new UnivaluedBinaryTree_965().isUnivalTree(root));
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        return isUnivalTreeHelper(root, root.val);
    }

    public boolean isUnivalTreeHelper(TreeNode root, int uniValue) {
        if (root == null){
            return true;
        }
        if (root.val != uniValue){
            return false;
        }
        return isUnivalTreeHelper(root.left,uniValue) && isUnivalTreeHelper(root.right,uniValue);
    }
}
