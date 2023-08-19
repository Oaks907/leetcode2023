package org.example.s2500_s2999;

import org.example.util.PrintUtil;

public class s2682_FindtheLosersoftheCircularGame {

    static int count = 0;

    public int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        recursion(arr, 0, k, 1);
        int[] ans = new int[n - count];

        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans[index++] = i + 1;
            }
        }
        return ans;
    }

    public void recursion(int[] arr, int currentIndex, int k, int i) {
        int index = (k * i + currentIndex) % arr.length;
        if (arr[index] == 1) {
            return;
        }
        arr[index] = 1;
        count++;
        recursion(arr, index, k, i + 1);
    }

    public static void main(String[] args) {
        s2682_FindtheLosersoftheCircularGame exe = new s2682_FindtheLosersoftheCircularGame();
//        PrintUtil.printIntArr(exe.circularGameLosers(4, 4));
        PrintUtil.printIntArr(exe.circularGameLosers(5, 2));
    }
}
