package org.example;
public class BinaryTree {

    static class Node
    {
        int data;
        Node left;
        Node right;
    }

    public static Node insert(Node root, int val)
    {
        Node node = new Node();
        if(root==null)
        {
            node.data = val;
            node.left = null;
            node.right = null;
            return node;
        }
        else
        {
            if(root.data > val)
            {
                root.left = insert(root.left, val);
            }
            else
            {
                root.right = insert(root.right, val);
            }

            return root;
        }
    }

    public static void inOrder(Node root)
    {
        if(root==null)
        {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 6);
        root = insert(root, 2);
        root = insert(root, 1);
        root = insert(root, 7);

        inOrder(root);
    }
}
