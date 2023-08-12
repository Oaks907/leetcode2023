package org.example.s0000_1000;

import com.google.common.collect.Lists;
import org.example.bo.ListNode;
import org.example.util.PrintUtil;

public class S0002_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode root = head;
        int carry = 0;
        int val = 0;
        while(l1 != null & l2 != null) {
            val = l1.val + l2.val + carry;
            if (val >= 10) {
                val %= 10;
                carry = 1;
            }  else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            root.next = node;
            root = root.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            val = l1.val + carry;
            if (val >= 10) {
                val %= 10;
                carry /= 1;
            }  else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            root.next = node;
            root = root.next;

            l1 = l1.next;
        }

        while(l2 != null) {
            val = l2.val + carry;
            if (val >= 10) {
                val %= 10;
                carry = 1;
            }  else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            root.next = node;
            root = root.next;

            l2 = l2.next;
        }

        if(carry > 0) {
            ListNode node = new ListNode(carry);
            root.next = node;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.init(Lists.newArrayList(2,4,9));
        ListNode l2 = ListNode.init(Lists.newArrayList(5,6,4,9));

        S0002_addTwoNumbers s0002 = new S0002_addTwoNumbers();
        PrintUtil.printListNode(s0002.addTwoNumbers(l1, l2));
    }
}
