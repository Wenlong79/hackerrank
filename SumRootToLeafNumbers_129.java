package com.wl.trees;

import java.util.HashMap;

public class SumRootToLeafNumbers_129 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        SumRootToLeafNumbers_129 obj = new SumRootToLeafNumbers_129();
        System.out.println(obj.sumNumbers(node));
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int num) {
        num = num * 10 + node.val;
        if (node.left == null && node.right == null){
            sum += num;
            return;
        }
        if (node.left != null){
            dfs(node.left, num);
        }
        if (node.right != null){
            dfs(node.right, num);
        }
    }

}
