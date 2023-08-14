package org.example.week.contest_358;

import com.google.common.collect.Lists;
import org.example.bo.ListNode;
import org.example.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class DoubleNumberRepresentedasLinkedList {


    public ListNode doubleIt(ListNode head) {

        ListNode curNode = head;
        List<Integer> list = new ArrayList<>();
        while (curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }

        if (list.size() == 0) {
            return head;
        }

        List<Integer> newList = new ArrayList<>();
        int carry = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer val = list.get(i);
            val = val * 2 + carry;

            if (val >= 10) {
                newList.add(val % 10);
            } else {
                newList.add(val);
            }
            carry = val / 10;
        }
        boolean needNewNode = carry > 0;
        if (carry > 0) {
            newList.add(carry);
        }

        curNode = head;
        ListNode pre = null;
        int index = newList.size() - 1;

        while (curNode != null) {

            curNode.val = newList.get(index--);

            pre = curNode;
            curNode = curNode.next;
        }

        if (needNewNode) {
            pre.next = new ListNode(newList.get(index));
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.init(Lists.newArrayList(9, 9, 9));
        DoubleNumberRepresentedasLinkedList exe = new DoubleNumberRepresentedasLinkedList();
        exe.doubleIt(node);
        PrintUtil.printListNode(node);

        node = ListNode.init(Lists.newArrayList(3, 4, 5, 4, 2, 5, 5, 9, 9, 9));
        exe.doubleIt(node);
        PrintUtil.printListNode(node);

        node = ListNode.init(Lists.newArrayList(0));
        exe.doubleIt(node);
        PrintUtil.printListNode(node);

        node = ListNode.init(Lists.newArrayList(1));
        exe.doubleIt(node);
        PrintUtil.printListNode(node);
    }
}
