package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDistanceBetweenBSTNodes_783 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        TreeNode root2 = new TreeNode(90, new TreeNode(69, new TreeNode(49, null, new TreeNode(52)), new TreeNode(89)), null);
        System.out.println(new MinimumDistanceBetweenBSTNodes_783().minDiffInBST(root2));
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> inOrderValues = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        inorder(root, inOrderValues);
        //Print.printList(inOrderValues);
        for (int i = 1; i < inOrderValues.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(inOrderValues.get(i) - inOrderValues.get(i - 1)));
        }
        return minDiff;
    }

    public void inorder(TreeNode root, List<Integer> inOrderValues) {
        if (root == null) {
            return;
        }
        inorder(root.left, inOrderValues);
        inOrderValues.add(root.val);
        inorder(root.right, inOrderValues);
    }
}
