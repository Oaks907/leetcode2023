package org.example.depth_first_search;

import org.example.bo.TreeNode;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/29 9:00
 **/
public class S0112_hasPathSum {

    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;

        S0112_hasPathSum hasPathSum = new S0112_hasPathSum();
        System.out.println(hasPathSum.hasPathSum(treeNode1, 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int currentVal) {

        if (root.left == null && root.right == null) {
            return targetSum == currentVal + root.val;
        } else if (root.left != null && root.right == null) {
            return hasPathSum(root.left, targetSum, currentVal + root.val);
        } else if (root.left == null && root.right != null) {
            return hasPathSum(root.right, targetSum, currentVal + root.val);
        } else {
            return hasPathSum(root.left, targetSum, currentVal + root.val) || hasPathSum(root.right, targetSum, currentVal + root.val);
        }
    }
}
