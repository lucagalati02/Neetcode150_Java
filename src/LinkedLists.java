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