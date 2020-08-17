public class ReverseLLIterative {
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
        ReverseLLIterative ll = new ReverseLLIterative();
        for(int i=0;i<5;i++){
            ll.push(i);
        }
        printList(head);
        printList(revreseListIterative());
    }
//the idea is here we assume before the curent node all previous nodes are revresed
//prev node is not connected to current, now we will operate on that and use next to keep hold of the rest of the ll on right side once revrsed
// N<-N(prev)     N(curr)->N(next)
    public static Node revreseListIterative(){
        Node curr = head;
        Node prev = null;
        while(curr!= null){
            Node next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}
