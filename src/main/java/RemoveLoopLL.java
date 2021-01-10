public class RemoveLoopLL {
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
        RemoveLoopLL list = new RemoveLoopLL();

        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        System.out.println("After Loop Removal");
        list.isLoop();
        //list.detectAndRemoveLoop(head);
        list.printList(head);

    }
//move two pointers to detect loops..once loop found keep fast as it is and bring slow to head
//move both now one step at a time they will meet at the start of loop
//fast.next and slow.next are used to keep track of the point from whr the loop can be broken
    public static void isLoop(){
        if (head == null || head.next == null)
            return;
        Node fast = head;
        Node slow = head;
        slow=slow.next;
        fast=fast.next.next;
        while(fast != null && fast.next != null){
            if(fast == slow)
                break;

            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow == fast)
            slow = head;
        while(slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        //we compare slow.next and fast.next because we want to track the previous node and change that to null
        fast.next=null;
    }

}
