package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST_230 {
    public static void main(String[] args) {
        KthSmallestElementInBST_230 obj = new KthSmallestElementInBST_230();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        obj.kthSmallest(root, 2);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        List<Integer> inOrderList = inOrderList(root, new ArrayList<>());
        //Print.printList(inOrderList);

        return inOrderList.get(k - 1);
    }

    public List<Integer> inOrderList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inOrderList(root.left, list);
        list.add(root.val);
        inOrderList(root.right, list);
        return list;
    }

}
