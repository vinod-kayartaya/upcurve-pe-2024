package com.targetindia.bst;

public class BinarySearchTree {


    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null; // not required; this is the default
            this.right = null; // not required; this is the default
        }
    }

    TreeNode root = null; // default for any member reference variable is null; not needed.

    public void insert(int data) {
        System.out.println("inserting " + data + "...");
        root = insert(root, data);
        System.out.println("Done inserting.");
    }

    private TreeNode insert(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        // this may be required if data is an object with other values as well (e.g, Employee)
        // node.data = data;
        return node;
    }

    public void display() {
        display(root, 0);
        System.out.println();
    }

    public void display(TreeNode node, int level) {
        if (node != null) {
            display(node.right, level + 1);
            System.out.println(" ".repeat(4 * level) + node.data);
            display(node.left, level + 1);
        }
    }

    public void preorderDisplay() {
        preorderDisplay(root);
        System.out.println();
    }

    private void preorderDisplay(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderDisplay(node.left);
            preorderDisplay(node.right);
        }
    }

    public void postorderDisplay() {
        postorderDisplay(root);
        System.out.println();
    }

    private void postorderDisplay(TreeNode node) {
        if (node != null) {
            postorderDisplay(node.left);
            postorderDisplay(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void inorderDisplay() {
        inorderDisplay(root);
        System.out.println();
    }

    private void inorderDisplay(TreeNode node) {
        if (node != null) {
            inorderDisplay(node.left);
            System.out.print(node.data + " ");
            inorderDisplay(node.right);
        }
    }


    public void delete(int data) {
        root = delete(root, data);
    }

    private TreeNode delete(TreeNode node, int data) {
        if (node == null) {
            return node;
        }

        if(data < node.data){
            node.left = delete(node.left, data);
        }
        else if(data > node.data){
            node.right = delete(node.right, data);
        }
        else {
            // we found the node to delete; which is the current node
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                // the current node has ONE child on the left side
                return node.left;
            }

            // find the smallest value (key) on the right subtree
            // or find the largest value (key) on the left subtree
            // make the current node's data = the above
            node.data = smallest(node.right);
            // OR
            // node.data = largest(node.left);
            node.right = delete(node.right, node.data);
            // delete the smallest/largest node recursively
        }

        return node;
    }

    private int smallest(TreeNode node){
        int data = node.data;
        var curr = node;
        while(curr.left !=null){
            data= curr.left.data;
            curr = curr.left;
        }
        return data;
    }


}
