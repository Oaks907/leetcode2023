package org.example.depth_first_search;

import org.example.bo.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/3 22:37
 **/
public class S0129_sumNumbers {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        recursion(root, 0);
        return ans;
    }

    private void recursion(TreeNode node, Integer val) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            ans += val + node.val;
            return;
        }

        int value = (val + node.val) * 10;
        recursion(node.left, value);
        recursion(node.right, value);
    }
}
