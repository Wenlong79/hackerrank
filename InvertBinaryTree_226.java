package com.wl.trees;

import com.wl.tools.Print;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6),null));
        Print.treeLevelOrderPrint(root);
        TreeNode invertedRoot = invertTree(root);
        Print.treeLevelOrderPrint(invertedRoot);
//        change(root);
//        Print.treeLevelOrderPrint(root);
        //System.out.println(invertedRoot.left.right.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode result = root;
        queue.offer(result);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            //System.out.println(node.val);
            if (!(node.left == null && node.right == null)){
                TreeNode newTempNode = node.left;
                node.left = node.right;
                node.right = newTempNode;
            }
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return result;
    }

    //use preorder
    public static TreeNode invertTree2(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        //swap
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
