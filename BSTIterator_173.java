package com.wl.trees;

import com.sun.source.tree.Tree;
import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    private List<Integer> inOrderList = new ArrayList<>();
    private int pointer = 0;

    public BSTIterator(TreeNode root) {
        inOrderList.add(Integer.MIN_VALUE);
        inOrder(root);
        //Print.printList(inOrderList);
    }

    public int next() {
        if (hasNext()) {
            pointer += 1;
            return inOrderList.get(pointer);
        }
        return Integer.MAX_VALUE;
    }

    public boolean hasNext() {
        return pointer < inOrderList.size() - 1;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }
}

public class BSTIterator_173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator obj = new BSTIterator(root);
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}
