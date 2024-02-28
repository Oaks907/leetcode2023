package org.example.depth_first_search;

import org.example.bo.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/27 21:43
 **/
public class S2331_evaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        return root.val == 3 ? (evaluateTree(root.left) && evaluateTree(root.right)) : (evaluateTree(root.left) || evaluateTree(root.right));
    }
}
