package org.example;

public class LinkedList {

    static class Node
    {
        int data;
        Node next;
    }

    public static Node insert(Node list, int val)
    {
        Node node = new Node();
        if(list==null)
        {
            node.data = val;
            node.next = null;
            return node;
        }
        else
        {
            Node temp = list;
            Node prev = null;
            while(list!=null)
            {
                prev = list;
                list = list.next;
            }
            prev.next = node;
            node.data = val;
            node.next = null;
            return temp;
        }
    }

    public static Node delete(Node node, int val)
    {
        Node temp = node;
        Node prev = null;
        while(temp!=null)
        {
            if(temp.data==val)
            {
                if(temp.next!=null)
                {
                    int num = temp.next.data;
                    temp.next.data = temp.data;
                    temp.data = num;
                }
                else
                {
                    prev.next = null;
                    return node;
                }
            }
            prev = temp;
            temp = temp.next;
        }

        return node;


    }

    public static void display(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        Node head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);

//        display(head);

//        delete(head,3);

        display(head);

    }


}
