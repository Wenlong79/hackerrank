package com.wl.trees;

import com.wl.tools.Print;

public class SecondMinimumNodeInBinaryTree_671 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(new SecondMinimumNodeInBinaryTree_671().findSecondMinimumValue(root));

    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        int[] top2Smallest = new int[3];
        top2Smallest[0] = root.val;
        top2Smallest[1] = Integer.MAX_VALUE;
        top2Smallest[2] = 0; // to indicate if top2Smallest[1] is changed
        inorder(root, top2Smallest);
        //Print.printArray(top2Smallest);
        if (top2Smallest[2] == 0) {
            return -1;
        } else {
            return top2Smallest[1];
        }
    }

    public void inorder(TreeNode root, int[] array) {
        if (root == null) {
            return;
        }
        //System.out.println(root.val);
        if (root.val != array[0] && root.val <= array[1]){
            array[1] = root.val;
            array[2] = 1;
        }
        inorder(root.left, array);
        inorder(root.right, array);
    }

}
