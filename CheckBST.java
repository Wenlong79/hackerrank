package com.wl.hakerrank;

import java.util.Stack;

public class CheckBST {

    public static void main(String[] args) {
        int[] preorderTraversal = {2, 1, 3, 4, 5};
        int[] test2 = {3, 4, 5, 1, 2};
        System.out.println(verifyBST(test2));
    }

    public static String verifyBST(int[] preorder) {

        if (preorder.length == 1) {
            return "YES";
        }
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int value : preorder) {
            if (value < root) {
                return "NO"; // Violation of BST property
            }

            while (!stack.isEmpty() && value > stack.peek()) {
                root = stack.pop();
            }

            stack.push(value);
        }

        return "YES";
    }

}
