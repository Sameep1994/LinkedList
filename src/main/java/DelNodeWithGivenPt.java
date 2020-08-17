public class DelNodeWithGivenPt {
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
        DelNodeWithGivenPt llist = new DelNodeWithGivenPt();
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);

        System.out.println("Before deleting");
        llist.printList(head);

        /* I m deleting the head itself.
        You can check for more cases */
        llist.delNode(llist.head);

        System.out.println("\nAfter Deleting");
        llist.printList(head);
    }

    public static void delNode(Node pt){
        Node temp = pt.next;
        pt.data = temp.data;
        pt.next= temp.next;
        temp=null;
    }
}
