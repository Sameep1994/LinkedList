public class MidleOfLinkedList {

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
    public static void main(String[] args) {
        MidleOfLinkedList ml = new MidleOfLinkedList();
        for (int i=5; i>0; --i)
        {
            ml.push(i);
        }
        ml.printList();
        ml.printMiddle();
    }

    public static void printMiddle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println("Middle Element is : "+slow.data);
    }

    public static void push(int new_data)
    {
        Node new_node = new Node(new_data);

        new_node.next = head;


        head = new_node;
    }


    public static void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
}
