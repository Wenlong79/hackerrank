package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;


public class N_aryTreePostorderTraversal_590 {
    public static void main(String[] args) {
        Node node_5 = new Node(5);
        Node node_6 = new Node(6);

        List<Node> subNodes_ofNode_3 = new ArrayList<>();
        subNodes_ofNode_3.add(node_5);
        subNodes_ofNode_3.add(node_6);
        Node node_3 = new Node(3, subNodes_ofNode_3);

        Node node_2 = new Node(2);
        Node node_4 = new Node(4);
        List<Node> subNodes_ofNode_1 = new ArrayList<>();
        subNodes_ofNode_1.add(node_3);
        subNodes_ofNode_1.add(node_2);
        subNodes_ofNode_1.add(node_4);

        Node root = new Node(1, subNodes_ofNode_1);
        Print.printList(new N_aryTreePostorderTraversal_590().postorder(root));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> postorderList = new ArrayList<>();
        if (root != null) {
            postorder_helper(root, postorderList);
        }
        return postorderList;
    }

    public void postorder_helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                postorder_helper(node, list);
            }
        }
        list.add(root.val);
    }
}
