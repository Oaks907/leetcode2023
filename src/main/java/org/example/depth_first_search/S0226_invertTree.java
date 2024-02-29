package org.example.depth_first_search;

import org.example.bo.TreeNode;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/28 22:24
 **/
public class S0226_invertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = invertTree(root.right);
        newNode.right =invertTree(root.left);

        return newNode;
    }
}
