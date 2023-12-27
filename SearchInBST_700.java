package com.wl.trees;

public class SearchInBST_700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        SearchInBST_700 obj = new SearchInBST_700();
        obj.searchBST(root, 2);
        //System.out.println(obj.searchBST(root, 2).val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }

        TreeNode node = root;
        while (node != null){
            if (val == node.val){
                return node;
            } else if (val > node.val){
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
