public class PalindromeLL {
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
        PalindromeLL list = new PalindromeLL();
        list.push(1);
        list.push(0);
        list.push(1);
        System.out.println(list.isPalindrome());
    }

    public static boolean isPalindrome(){
        Node slow=head;
        Node fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       Node rev = revreseListIterative(slow);
       Node curr =head;
    while (rev != null){
        if(rev.data!=curr.data)
            return false;
        rev=rev.next;
        curr=curr.next;
    }
        return true;
    }

    public static Node revreseListIterative(Node head){
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
