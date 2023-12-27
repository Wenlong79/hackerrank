package com.wl.trees;


import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MinAbsDiffInBST_530 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(new MinAbsDiffInBST_530().getMinimumDifference(root));
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        generateList(root, list);
        //Print.printList(list);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            result = Math.min(result, list.get(i) - list.get(i - 1));
        }
        return result;
    }

    public void generateList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        generateList(root.left, list);
        list.add(root.val);
        generateList(root.right, list);
    }
}
