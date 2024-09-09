/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class Node {
        int key;
        int val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertAtHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        insertAtHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        int val = get(key);
        if (val != -1) {
            this.head.next.val = value;
        } else {
            Node newNode = new Node(key, value);
            insertAtHead(newNode);
            map.put(newNode.key, newNode);
            if (map.size() > capacity) {
                Node node = map.get(tail.prev.key);
                removeNode(node);
                map.remove(node.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
