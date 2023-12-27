package com.wl.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBT_111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(root));

    }

    public static int minDepth(TreeNode root) {
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

            if (node.left == null && node.right == null){  // leaf node
                height++;
                return height;
            }
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

    public static int minDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null || root.right == null) {
            // 2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度(need leaf node!)
            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);
            return m1 + m2 + 1;
        } else {
            // both left and right are not null
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
