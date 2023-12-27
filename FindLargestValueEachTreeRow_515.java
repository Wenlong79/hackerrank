package com.wl.trees;

import com.wl.tools.Print;

import java.util.*;

public class FindLargestValueEachTreeRow_515 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        Print.printList(largestValues(node));
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //int height = 0;
        int levelSize = 1;
        int levelMax = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            //System.out.print(node.val + "__");
            levelMax = Math.max(levelMax, node.val);
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {
                //height++;
                levelSize = queue.size();
                result.add(levelMax);
                levelMax = Integer.MIN_VALUE;
            }

        }
//        System.out.println();
//        System.out.println("Height: " + height);

        return result;
    }
}
