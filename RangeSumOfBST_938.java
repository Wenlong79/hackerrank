package com.wl.trees;

import com.sun.source.tree.Tree;

public class RangeSumOfBST_938 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        System.out.println(new RangeSumOfBST_938().rangeSumBST(root, 7, 15));
    }

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        inOrderTraversal(root, low, high);
        return sum;
    }

    public void inOrderTraversal(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, low, high);
        //System.out.println(root.val);
        if (root.val >= low && root.val <= high){
            sum += root.val;
        }
        inOrderTraversal(root.right, low, high);
    }
}
