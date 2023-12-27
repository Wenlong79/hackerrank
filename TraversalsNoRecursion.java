package com.wl.trees;

import java.util.*;

public class TraversalsNoRecursion {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(4, new TreeNode(2), new TreeNode(1)), new TreeNode(6));
        List<Integer> list = preorderTraversal(treeNode);
        System.out.println(list);
        List<Integer> list2 = postorderTraversal(treeNode);
        System.out.println(list2);
        List<Integer> list3 = inorderTraversal(treeNode);
        System.out.println(list3);
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            list.add(popNode.val);
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
        return list;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            list.add(popNode.val);
            if (popNode.left != null) {
                stack.push(popNode.left);
            }
            if (popNode.right != null) {
                stack.push(popNode.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
