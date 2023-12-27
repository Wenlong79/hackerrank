package com.wl.trees;

import com.sun.jdi.Value;
import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        FindBottomLeftTreeValue_513 obj = new FindBottomLeftTreeValue_513();
        System.out.println(obj.findBottomLeftValue(root));

    }

    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.offer(root);
        int levelSize = 1;
        List<Integer> lastRow = new ArrayList<>();
        int result = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;
            //System.out.print(node.val + " __ ");
            lastRow.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {
                //Print.printList(lastRow);
                result = lastRow.get(0);
                height += 1;
                levelSize = queue.size();
                lastRow.clear();
            }
        }

//        System.out.println();
//        System.out.println("Height: " + height);
        return result;
    }
}
