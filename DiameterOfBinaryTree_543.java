package com.wl.trees;

public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new DiameterOfBinaryTree_543().diameterOfBinaryTree(node));
    }

    //两个node之间路径 = root's left and right nodes' 深度之和
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        depthOfNode(root);
        return diameter;
    }

    public int depthOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int depthOfLeft = depthOfNode(node.left);
        int depthOfRight = depthOfNode(node.right);
        diameter = Math.max(diameter, (depthOfLeft + depthOfRight));
        return Math.max(depthOfLeft, depthOfRight) + 1;
    }

}
