public class CloneLL {
    // Java program to clone a linked list with next
// and arbit pointers in O(n) time
    static class GfG
    {

        // Structure of linked list Node
        static class Node
        {
            int data;
            Node next,random;
            Node(int x)
            {
                data = x;
                next = random = null;
            }
        }

        // Utility function to print the list.
        static void print(Node start)
        {
            Node ptr = start;
            while (ptr != null)
            {
                System.out.println("Data = " + ptr.data +
                        ", Random = "+ptr.random.data);
                ptr = ptr.next;
            }
        }

        // This function clones a given
// linked list in O(1) space
        static Node clone(Node start)
        {
            Node curr = start, temp = null;

            // insert additional node after
            // every node of original list
            while (curr != null)
            {
                temp = curr.next;

                // Inserting node
                curr.next = new Node(curr.data);
                curr.next.next = temp;
                curr = temp;
            }
            curr = start;

            // adjust the random pointers of the
            // newly added nodes
            while (curr != null)
            {
                if(curr.next != null)
                    curr.next.random = (curr.random != null)
                            ? curr.random.next : curr.random;

                // move to the next newly added node by
                // skipping an original node
                curr = (curr.next != null) ? curr.next.next
                        : curr.next;
            }

            Node original = start, copy = start.next;

            // save the start of copied linked list
            temp = copy;

            // now separate the original list and copied list
            while (original != null && copy != null)
            {
                original.next = (original.next != null)?
                        original.next.next : original.next;

                copy.next = (copy.next != null) ? copy.next.next
                        : copy.next;
                original = original.next;
                copy = copy.next;
            }
            return temp;
        }

        public static Node copy(Node head){
            //create a copy of node next to the current nodes
            Node ptr=head;
            while (ptr!=null){
                Node cloneNode = new Node(ptr.data);

                cloneNode.next=ptr.next;
                ptr.next=cloneNode;
                ptr=cloneNode.next;
            }

            ptr=head;
            //copy the random values
            while (ptr!=null){
               if(ptr.random!=null){
                   ptr.next.random=ptr.random.next;
               }else {
                   ptr.next.random=null;
               }

                ptr=ptr.next.next;
            }

            //untangle new and old
            Node old_list = head;
            Node new_list = head.next;
            Node res = new_list;
            while (old_list!=null){
            old_list.next=old_list.next.next;
            new_list.next=(new_list.next !=null)?new_list.next.next:null;

            old_list=old_list.next;
            new_list=new_list.next;
            }

            return res;
        }


        // Driver code
        public static void main(String[] args)
        {
            Node start = new Node(1);
            start.next = new Node(2);
            start.next.next = new Node(3);
            start.next.next.next = new Node(4);
            start.next.next.next.next = new Node(5);

            // 1's random points to 3
            start.random = start.next.next;

            // 2's random points to 1
            start.next.random = start;

            // 3's and 4's random points to 5
            start.next.next.random = start.next.next.next.next;
            start.next.next.next.random = start.next.next.next.next;

            // 5's random points to 2
            start.next.next.next.next.random = start.next;

            System.out.println("Original list : ");
            print(start);

            System.out.println("Cloned list : ");
            Node cloned_list = clone(start);
            print(cloned_list);

            System.out.println("------------------");
            print(copy(start));
        }
    }



}
