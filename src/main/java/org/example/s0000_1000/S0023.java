package org.example.s0000_1000;

import com.google.common.collect.Lists;
import org.example.bo.ListNode;
import org.example.util.PrintUtil;

public class S0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode root = head;
        ListNode minNode = findMinValueNode(lists);
        while (minNode != null) {
            head.next = minNode;
            head = head.next;

            minNode = findMinValueNode(lists);
        }

        return root.next;
    }

    private ListNode findMinValueNode(ListNode[] list) {
        int index = -1;
        ListNode minVal = null;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                continue;
            }
            if (minVal == null || minVal.val > list[i].val) {
                minVal = list[i];
                index = i;
            }
        }

        if (index != -1) {
            list[index] = list[index].next;
        }
        return minVal == null ? null : new ListNode(minVal.val);
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.init(Lists.newArrayList(1, 4, 5));
        ListNode l2 = ListNode.init(Lists.newArrayList(1, 3, 4));
        ListNode l3 = ListNode.init(Lists.newArrayList(2, 6));

        ListNode[] arr = new ListNode[3];
        arr[0] = l1;
        arr[1] = l2;
        arr[2] = l3;

        S0023 s0023 = new S0023();
        ListNode listNode = s0023.mergeKLists(arr);
        PrintUtil.printListNode(listNode);
    }
}
