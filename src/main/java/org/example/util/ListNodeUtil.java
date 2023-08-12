package org.example.util;

import org.example.bo.ListNode;

public class ListNodeUtil {

    public static void print(ListNode node) {
        System.out.print("当前队列值为:");
        if (node == null) {
            return;
        }

        while(node != null) {

            System.out.print(node.val + "->");

            node = node.next;
        }
    }
}
