package com.wl.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBT_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepthPro(root));
    }


    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
    }

    public static int maxDepthPro(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            if (levelSize == 0){
                height++;
                levelSize = queue.size();
            }
        }
        return height;
    }
}
