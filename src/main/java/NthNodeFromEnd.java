public class NthNodeFromEnd {
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


    public static void main(String[] args) {
        NthNodeFromEnd ll = new NthNodeFromEnd();
        for(int i=0;i<5;i++){
            ll.push(i);
        }
        ll.printList();
        int n=1;
        ll.printNthNodeFromEnd(n);
    }

    public static void printNthNodeFromEnd(int n){
        Node fast = head;
        Node slow = head;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println("Nth Node from end is: "+slow.data);
    }
}
