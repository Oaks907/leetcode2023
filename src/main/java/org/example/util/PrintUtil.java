package org.example.util;

import org.example.bo.ListNode;

public class PrintUtil {

    public static void printListNode(ListNode node) {
        System.out.print("当前队列值为:");
        if (node == null) {
            return;
        }

        while(node != null) {

            System.out.print(node.val + "->");

            node = node.next;
        }
        System.out.println();
    }

    public static void printIntArr(int[] arr) {
        System.out.print("数组为：");
        if (null == arr) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
