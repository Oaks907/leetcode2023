package org.example.depth_first_search;

import org.example.bo.TreeNode;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/29 11:25
 **/
public class LCP0067_expandBinaryTree {

    @Test
    public void test() {
            TreeNode treeNode1 = new TreeNode(1);
            TreeNode treeNode2 = new TreeNode(2);
            treeNode1.left = treeNode2;

        LCP0067_expandBinaryTree hasPathSum = new LCP0067_expandBinaryTree();
            System.out.println(hasPathSum.expandBinaryTree(treeNode1));
    }

    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = expandBinaryTree(root.left);
        if (left != null) {
            TreeNode treeNode = new TreeNode(-1);
            root.left = treeNode;
            treeNode.left = left;
        }
        TreeNode right = expandBinaryTree(root.right);
        if (right != null) {
            TreeNode treeNode = new TreeNode(-1);
            root.right = treeNode;
            treeNode.right = right;
        }
        return root;
    }
}
