import java.io.*;
import java.util.*;

public class LinkedLists {
    //https://neetcode.io/problems/reverse-a-linked-list
    //44:13
    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //https://neetcode.io/problems/merge-two-sorted-linked-lists
        //11:16
        ListNode head = new ListNode(0);
        ListNode node = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        return head.next;
    }

    boolean hasCycle(ListNode head) {
        //https://neetcode.io/problems/linked-list-cycle-detection
        //4:37
        ListNode node = head;
        HashSet<ListNode> set = new HashSet<>();

        while (node != null) {
            if (!set.contains(node)) {
                set.add(node);
                node = node.next;
            }
            else {
                return true;
            }
        }
        return false;
    }

    void reorderList(ListNode head) {
        //D.N.C.
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        //https://neetcode.io/problems/remove-node-from-end-of-linked-list
        //34:45
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        if (n == length) {
            return head.next;
        }

        int stopAt = length - n - 1;
        current = head;
        for (int i = 0; i < stopAt; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    Node copyRandomList(Node head) {
        //https://neetcode.io/problems/copy-linked-list-with-random-pointer
        //48:23
        if (head == null) return null;

        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node clone = map.get(cur);
            clone.next   = map.get(cur.next);   // null-safe: map.get(null) -> null
            clone.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //https://neetcode.io/problems/add-two-numbers
        //15:46
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        String str1 = sb1.reverse().toString();
        String str2 = sb2.reverse().toString();

        java.math.BigInteger num1 = new java.math.BigInteger(str1);
        java.math.BigInteger num2 = new java.math.BigInteger(str2);
        java.math.BigInteger sum = num1.add(num2);

        // Reverse the result again to match the required linked list format (least significant digit first)
        String sumString = new StringBuilder(sum.toString()).reverse().toString();

        // Build the result list
        ListNode head = new ListNode(Character.getNumericValue(sumString.charAt(0)));
        ListNode current = head;

        for (int i = 1; i < sumString.length(); i++) {
            current.next = new ListNode(Character.getNumericValue(sumString.charAt(i)));
            current = current.next;
        }

        return head;
    }

    public int findDuplicate(int[] nums) {
        //https://neetcode.io/problems/find-duplicate-integer
        //3:18
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else {
                return nums[i];
            }
        }
        return -1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//{
//https://neetcode.io/problems/lru-cache
//47:39
class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy nodes to avoid null checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
//}