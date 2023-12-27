package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST_98 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3, null, new TreeNode(7, new TreeNode(10), null)));
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        TreeNode root3 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        ValidateBST_98 obj = new ValidateBST_98();

        System.out.println(obj.isValidBSTPro(root3));


    }

    public boolean isValidBSTPro(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        long lower = Long.MIN_VALUE;
        long upper = Long.MAX_VALUE;
        return dfs(root, lower, upper);
    }

    public boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return dfs(node.left, lower, node.val) && dfs(node.right, node.val, upper);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        //Print.printList(inOrderList);
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= inOrderList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        //System.out.println(root.val);
        inOrder(root.right, list);
    }
}
