package com.wl.trees;

import com.wl.tools.Print;

import java.util.*;

public class FindModeInBST_501 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(3, new TreeNode(1), new TreeNode(3)), new TreeNode(10, new TreeNode(7), new TreeNode(10)));
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2));
        Print.printArray(new FindModeInBST_501().findMode(root1));
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            int[] result = new int[0];
            return result;
        }
        if (root.left == null && root.right == null) {
            int[] result = new int[1];
            result[0] = root.val;
            return result;
        }
        List<Integer> inOrderList = new ArrayList<>();
        inOrderList = getInOrder(root, inOrderList);
        Print.printList(inOrderList);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer element : inOrderList) {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
        Print.printMap(map);

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] valueToF = new int[2];
            valueToF[0] = entry.getKey();
            valueToF[1] = entry.getValue();
            heap.offer(valueToF);
        }

        int maxFrequency = heap.peek()[1];
        System.out.println(maxFrequency);
        List<Integer> resultList = new ArrayList<>();
        while (!heap.isEmpty() && heap.peek()[1] == maxFrequency) {
            System.out.println("here");
            resultList.add(heap.poll()[0]);
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public List<Integer> getInOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        getInOrder(root.left, list);
        list.add(root.val);
        getInOrder(root.right, list);
        return list;
    }
}
