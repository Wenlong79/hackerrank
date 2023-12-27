package com.wl.trees;

public class DeleteNodeInBST_450 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        DeleteNodeInBST_450 obj = new DeleteNodeInBST_450();
        TreeNode result = obj.deleteNode(node, 3);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }

            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }

        return root;
    }
}
