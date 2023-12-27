package com.wl.trees;

import com.wl.tools.Print;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class N_aryTreePreorderTraversal_589 {
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
        //System.out.println("hello");
        //preorderX(root);
        Print.printList(new N_aryTreePreorderTraversal_589().preorder(root));

    }

    public static void preorderX(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorderX(node);
            }
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> preorderList = new ArrayList<>();

        if (root != null){
            preorder_helper(root,preorderList);
        }
        //Print.printList(preorderList);
        return preorderList;
    }

    public void preorder_helper(Node root, List<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.val);
        if (root.children != null){
            for (Node node : root.children){
                preorder_helper(node, list);
            }
        }
    }
}
