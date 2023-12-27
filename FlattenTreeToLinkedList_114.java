/**
 *
 */
package com.wl.trees;

import java.util.ArrayList;

/**
 * @author wenlongy
 *
 */
public class FlattenTreeToLinkedList_114 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        new FlattenTreeToLinkedList_114().flatten(root);
        System.out.println(root.right.right.val);
    }

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        preorderTrav(root, list);
        TreeNode move = root;
        for (int i = 1; i < list.size(); i++) {
            move.left = null;
            move.right = list.get(i);
            move = move.right;
        }
    }

    public static void preorderTrav(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorderTrav(root.left, list);
        preorderTrav(root.right, list);
    }

}
