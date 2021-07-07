public class pairwiseswap {
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
        pairwiseswap list = new pairwiseswap();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.printList(head);
        list.printList(list.pairSwap(head));
    }

//assume that before the curr node all nodes are reversed pair wise and the prev node is yet to be ref
    public static Node pairSwap(Node head){
        if(head==null || head.next==null)
            return head;
        //takes care to pt the head at correct place
        Node prev = head;
        Node curr = head.next.next;
        head = head.next;
        head.next=prev;
        while(curr != null && curr.next!=null){
           //watch geeks for geeks for visual rep
            prev.next=curr.next;
            prev=curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr=next;
        }
        prev.next=curr;
        return head;
    }
}
