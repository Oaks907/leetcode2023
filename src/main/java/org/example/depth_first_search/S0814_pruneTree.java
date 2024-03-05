package org.example.depth_first_search;

import org.example.bo.TreeNode;
import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/4 8:42
 **/
public class S0814_pruneTree {

    @Test
    public void test() {
        Integer[] arr = {1, 1, 0, 1, 1, 0, 1, 0};
        TreeNode treeNode = PrintUtil.constructTree(arr);
        PrintUtil.printTreeNode(treeNode);

        S0814_pruneTree exe = new S0814_pruneTree();
        TreeNode treeNode1 = exe.pruneTree(treeNode);

        PrintUtil.printTreeNode(treeNode1);
    }


    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = new TreeNode(-1);
        node.left = root;
        recursion(node);
        return node.left;
    }

    public boolean recursion(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean left = recursion(root.left);
        boolean right = recursion(root.right);

        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }

        return root.val == 1 || left || right;
    }
}
