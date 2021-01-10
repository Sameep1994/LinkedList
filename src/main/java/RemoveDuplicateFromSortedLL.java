public class RemoveDuplicateFromSortedLL {
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
        head = new Node(10);
        head.next=new Node(20);
        head.next.next = new Node(20);
        head.next.next.next=new Node(30);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next=new Node(30);

        removeDup(head);
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
//10->20->20->30 if we are on 20 we see 20 and next element is also 20
//we point 20 to 30 ie curr.next=curr.next.next
    public static void removeDup(Node head){
        Node curr=head;
        while (curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;

            }else {
                curr=curr.next;
            }
        }
    }

    
}
