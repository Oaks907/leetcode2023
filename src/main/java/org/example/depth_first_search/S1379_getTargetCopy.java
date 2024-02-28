package org.example.depth_first_search;

import org.example.bo.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/27 22:01
 **/
public class S1379_getTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original, cloned.left, target);
        TreeNode right = getTargetCopy(original, cloned.right, target);

        return left == null ? right : left;
    }
}
