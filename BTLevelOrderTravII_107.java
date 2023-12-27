package com.wl.trees;

import com.wl.tools.Print;

import java.util.*;

public class BTLevelOrderTravII_107 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7, new TreeNode(6), new TreeNode(10)));
        List<List<Integer>> result = levelOrderBottom(root);
        Print.print2DList(result);
        //Print.treeLevelOrderPrint(root);

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //int height = 0;
        int levelSize = 1;
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;
            //System.out.println(node.val);
            levelList.add(node.val);

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
            if (levelSize == 0){
                //height++;
                result.add(0,levelList);
                levelSize = queue.size();
                levelList = new ArrayList<>();
            }
        }
        //System.out.println("H: " + height);
        return result;
    }

    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.offer(root);
        int levelSize = 1;
        int height = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;
            //System.out.println(node.val);
            list.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                stack.push(list);
                levelSize = queue.size();
                height++;
                list = new ArrayList<>();
            }
        }
        //System.out.println(stack.peek().toString());
//		System.out.println(height+" h");
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
