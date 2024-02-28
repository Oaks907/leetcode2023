package org.example.depth_first_search;

import org.example.bo.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/27 21:21
 **/
public class S0938_RangeSumofBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }


        int val = root.val;
        boolean leftExist = val >= low;
        boolean rightExist = val <= high;
        return ((leftExist && rightExist) ? val : 0) + (leftExist ? rangeSumBST(root.left, low, high) : 0) + (rightExist ? rangeSumBST(root.right, low, high) : 0);
    }
}
