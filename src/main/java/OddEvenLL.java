public class OddEvenLL {
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
    OddEvenLL list = new OddEvenLL();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.printList(head);
        list.oddEveSeg();
        list.printList(head);
    }

    public static void oddEveSeg(){
        Node es=null,ee=null,os=null,oe=null;
        for(Node curr=head; curr!=null; curr=curr.next){
            int x = curr.data;
            if(x%2==0){
                if(es==null){
                    es=curr;
                    ee=es;
                }else{
                    ee.next=curr;
                    ee=ee.next;
                }
            }else{
                if(os==null){
                    os=curr;
                    oe=os;
                }else{
                    oe.next=curr;
                    oe=oe.next;
                }
            }
        }
        if(os==null || es== null) {
            return;
        }
        ee.next=os;
        oe.next=null;
        head=es;
    }
}
