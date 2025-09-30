package stack;



import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, DllNode> map;
    private DllNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes for easy handling
        head = new DllNode(0, 0);
        tail = new DllNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // ✅ Get operation
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DllNode node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }

    // ✅ Put operation
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); // old remove
        }
        if (map.size() == capacity) {
            remove(tail.prev); // remove LRU
        }
        insertToHead(new DllNode(key, value));
    }

    // ✅ Helper: Remove node from DLL
    private void remove(DllNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // ✅ Helper: Insert node after head (MRU position)
    private void insertToHead(DllNode node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        lru.put(1, 1); // {1=1}
        lru.put(2, 2); // {1=1, 2=2}
        System.out.println(lru.get(1)); // 1

        lru.put(3, 3); // removes key=2 → {1=1, 3=3}
        System.out.println(lru.get(2)); // -1

        lru.put(4, 4); // removes key=1 → {4=4, 3=3}
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 3
        System.out.println(lru.get(4)); // 4
    }
}
