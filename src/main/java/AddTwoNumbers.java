public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next=new ListNode(4);
        node1.next.next= new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next=new ListNode(6);
        node2.next.next=new ListNode(4);

        printList(addTwoNumbers(node1,node2));



    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //result node
        ListNode dum_head = new ListNode(0);
        ListNode l3 = dum_head;
        int carry=0;
        //add digit by digit ,
        while(l1!=null || l2!=null){
            //if the two list of not same type we take 0 in its place
            int l1_val = (l1!=null)?l1.val:0;
            int l2_val = (l2!=null)?l2.val:0;
            //sum the values and the carry from previous operation
            int curr_sum = l1_val+l2_val+carry;
            //find the carry when presnt
            carry=curr_sum/10;
            //in case of carry get the digit post carry
            int last_digit = curr_sum%10;

            //push the last digit in the linked list
            ListNode new_node = new ListNode(last_digit);
            l3.next=new_node;

            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            l3=l3.next;
        }
        //for scenarios like 900+900=1800 to store 1
        if(carry>0){
            ListNode ex_node = new ListNode(carry);
            l3.next=ex_node;
            l3=l3.next;
        }
        return dum_head.next;
    }


    public static void printList(ListNode tnode)
    {
        while (tnode != null)
        {
            System.out.print(tnode.val+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(int d)
    {
        val = d;
        next = null;
    }
}
