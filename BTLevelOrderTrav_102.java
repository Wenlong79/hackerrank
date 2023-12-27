package com.wl.trees;

import com.wl.tools.Print;

import java.util.*;

public class BTLevelOrderTrav_102 {
    public static void main(String[] args) {
//        List<List<Integer>> twoD_List = new ArrayList<List<Integer>>();
//        twoD_List.add(Arrays.asList(1,2,3));
//        twoD_List.add(Arrays.asList(4,5,6));
//        Print.print2DList(twoD_List);
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7, new TreeNode(6), new TreeNode(10)));
        List<List<Integer>> result = levelOrder(root);
        Print.print2DList(result);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;
        List levelList = new ArrayList();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //System.out.println(node.val);
            levelList.add(node.val);
            levelSize -= 1;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {
                height += 1;
                result.add(levelList);
                levelSize = queue.size();
                levelList = new ArrayList();
            }
        }
        //System.out.println("h: " + height);
        return result;
    }
}
