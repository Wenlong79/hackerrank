package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8)));
        TreeNode root2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));

        LeafSimilarTrees_872 obj = new LeafSimilarTrees_872();
        System.out.println(obj.leafSimilar(root1, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1_leaves = new ArrayList<>();
        List<Integer> root2_leaves = new ArrayList<>();
        getLeaves(root1, root1_leaves);
        getLeaves(root2, root2_leaves);
        return root1_leaves.equals(root2_leaves);
    }


    public void getLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            //System.out.println(root.val);
            list.add(root.val);
        }
        getLeaves(root.left, list);
        getLeaves(root.right, list);
    }
}
