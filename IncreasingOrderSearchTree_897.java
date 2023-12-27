package com.wl.trees;

import com.sun.source.tree.Tree;
import com.wl.tools.Print;

import java.util.Stack;

public class IncreasingOrderSearchTree_897 {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(8)));
        TreeNode ans = increasingBST(node);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.right;
        }
    }


    public static TreeNode increasingBST(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        inOrderTraverse(root, stack);
        //Print.printStack(stack);
        TreeNode node = new TreeNode(stack.pop());
        while (!stack.isEmpty()) {
            node = new TreeNode(stack.pop(), null, node);
        }
        return node;
    }


    public static void inOrderTraverse(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, stack);
        stack.push(root.val);
        inOrderTraverse(root.right, stack);
    }
}
