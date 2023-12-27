package com.wl.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTra_94 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(2), new TreeNode(7, new TreeNode(6), null));
        List<Integer> list = inorderTraversal(treeNode);
        System.out.println(list);

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inorderHelper(root, list);
        return list;
    }

    public static void inorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, list);
        list.add(root.val);
        inorderHelper(root.right, list);
    }

}
