import java.util.HashMap;

class Node1 {
    int key;
    int value;
    Node1 pre;
    Node1 next;

    public Node1(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    //It stores the nodes value and location, to quicly identify if the current eleemnt exist in cache or not
    private HashMap<Integer, Node1> map;
    private int cache_capacity, count;
    private Node1 head, tail;
//init cache
    public LRUCache(int capacity)
    {
        this.cache_capacity = capacity;
        map = new HashMap(capacity);
        //dummy head and tail
        head = new Node1(0, 0);
        tail = new Node1(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }
//delete from end
    public void deleteNode(Node1 node)
    {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
//add to start of list
    public void addToHead(Node1 node)
    {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key)
    {
        //if in hashmap,remove it from ll and add to front
        if (map.get(key) != null) {
            Node1 node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }

    public void set(int key, int value)
    {
        //if it exist in cache already,remove and add to head of cache
        System.out.println("Going to set the (key, "+
                "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            Node1 node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            if(map.size()==cache_capacity) {
                //if we have reached capacity
                //remove from map and linkedlist and add new one
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
            //add to map and ll
            Node1 new_node =new Node1(key,value);
            map.put(key,new_node);
            addToHead(new_node);
        }
    }
}

public class TestLRUCache {
    public static void main(String[] args)
    {

        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value 
        // 10 in the cache. 
        cache.set(1, 10);

        // it will store a key (2) with value 20 in the cache. 
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10 

        // removing key 2 and store a key (3) with value 30 in the cache. 
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found) 

        // removing key 1 and store a key (4) with value 40 in the cache. 
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found) 
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30 
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40 
    }
} 
