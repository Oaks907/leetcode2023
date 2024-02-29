package org.example.depth_first_search;

import org.example.bo.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/29 8:12
 **/
public class S0111_minDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        } else if (root.left != null && root.right == null) {
            return 1+ minDepth(root.left);
        } else {
            return 1;
        }
    }
}
