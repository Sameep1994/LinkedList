public class InsertNodeInSortedLL {
    public static Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }


    public static void printList(Node tnode)
    {
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node list = new Node(10);
        list.next=new Node(20);
        list.next.next=new Node(30);
        list.next.next.next=new Node(40);
        int x = 35;
        System.out.println(sortInsert(list,x).data);
    }
//we are traversing till we are getting elements less than the element we want to insert
//corner case when the element is lesser than head
    public static Node sortInsert(Node head,int x){
        Node temp = new Node(x);
        if(head==null)
            return temp;
        if(x<head.data) {
            temp.next = head;
            return temp;
        }
        Node curr =head;
        while (curr.next!=null && curr.next.data<x){
            curr=curr.next;
        }
        temp.next=curr.next;
        curr.next=temp;
        return temp;
    }
}
