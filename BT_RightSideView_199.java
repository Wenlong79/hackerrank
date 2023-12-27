package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BT_RightSideView_199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        Print.printList(rightSideViewPro(root));
    }

    public static List<Integer> rightSideViewPro(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize -= 1;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {
                height += 1;
                result.add(node.val);
                levelSize = queue.size();
            }
        }

        return result;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> allLevelLists = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;
        List levelList = new ArrayList();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
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
                allLevelLists.add(levelList);
                levelSize = queue.size();
                levelList = new ArrayList();
            }
        }

        //Print.print2DList(allLevelLists);

        for (int i = 0; i < allLevelLists.size(); i++){
            List<Integer> currentList = allLevelLists.get(i);
            result.add(currentList.get(currentList.size()-1));
        }

        return result;
    }
}
