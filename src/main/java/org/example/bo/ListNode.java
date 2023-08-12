package org.example.bo;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        ListNode root = new ListNode(list.get(0));
        ListNode head = root;

        for (int i = 1; i < list.size(); i++) {
            head.next = new ListNode(list.get(i));
            head = head.next;
        }

        return root;
    }
}
