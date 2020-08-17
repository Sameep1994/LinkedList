public class ReverseLLInGroups {
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
        ReverseLLInGroups ll = new ReverseLLInGroups();
        for (int i=0;i<6;i++){
            ll.push(i);
        }
        printList(head);
        printList(reverseLLInGroupRec(head,3));

    }
//first k nodes are reveresed and then the end of those k node is marked and for next k nodes again linked list reversal is called
//and the two are joined
    public static Node reverseLLInGroupRec(Node head,int k){
        Node curr = head;
        Node prev = null;
        Node next =null;
        int count =0;
        while(curr!= null && count<k){
             next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null){
            Node rest_head = reverseLLInGroupRec(next,k);
            head.next=rest_head;
        }
        return prev;
    }
}
