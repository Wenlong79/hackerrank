package com.wl.trees;

public class ArrayToBST_108 {
    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        System.out.println(sortedArrayToBST(nums).left.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return BST_Helper(nums, 0, nums.length - 1);
    }

    public static TreeNode BST_Helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST_Helper(nums, left, mid - 1);
        root.right = BST_Helper(nums, mid + 1, right);
        return root;
    }
}
