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

    public boolean hasCycle(ListNode head) {
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
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}