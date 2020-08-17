public class ReverseLLRec {
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
        ReverseLLRec ll = new ReverseLLRec();
        for(int i=0;i<5;i++){
            ll.push(i);
        }
        ll.printList(head);
        ll.printList(recRev1(head));
        System.out.println("next method");
        ReverseLLRec ll1 = new ReverseLLRec();
        for(int i=0;i<5;i++){
            ll1.push(i);
        }
        ll1.printList(head);
        Node prev=null;
        Node curr = ll1.head;
        ll1.printList(ll1.recRev2(curr,prev));
    }
//we are calling reverse fun recursively for all the nodes after head
//we are using a pointer tail which is taking care of last revrsal
    public static Node recRev1(Node head){
        if(head==null || head.next == null)
            return head;
        Node rest_head = recRev1(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }
//this method is similar to iterative method
//we are getting hold of curr marking prev and next and recursively reversing
    public static Node recRev2(Node curr, Node prev){
        if(curr==null)
            return prev;
        //marking next node
        Node next = curr.next;
        //reversing the refernece
        curr.next=prev;
        return recRev2(next,curr);
    }
}
