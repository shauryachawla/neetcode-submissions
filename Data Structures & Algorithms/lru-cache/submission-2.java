public class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node top;
    Node bottom;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.top = new Node(0,0);
        this.bottom = new Node(0,0);
        this.top.prev = this.bottom;
        this.bottom.next = this.top;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            return this.get(cache.get(key));
        } else return -1;
    }

    public int get(Node node) {
        remove(node);
        insert(node);
        return node.val;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = top.prev;
        prev.next = node;
        node.prev = prev;
        node.next = top;
        top.prev = node;
    }
    
    public void put(int key, int value) {
        Node node;
        // old key
            // remove old node
            // insert new node with updated val
            // update cache
        if(cache.containsKey(key)) {
            node = cache.get(key);
            remove(node);
            cache.remove(key);
        }
        if(cache.size() >= capacity) {
            Node bottomNode = bottom.next;
            remove(bottomNode);
            cache.remove(bottomNode.key);
        }
        node = new Node(key, value);
        insert(node);
        cache.put(key, node);
        
        // new key
            // capacity full
                // remove bottom
                // remove from cache
            // capacity ok
                // insert new node
                // insert in cache

    }
}
