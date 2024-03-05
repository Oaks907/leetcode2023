package org.example.depth_first_search;

import org.example.bo.TreeNode;
import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/4 8:37
 **/
public class S0236_lowestCommonAncestor_v2 {

    @Test
    public void test() {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = PrintUtil.constructTree(arr);
        PrintUtil.printTreeNode(treeNode);

        S0236_lowestCommonAncestor exe = new S0236_lowestCommonAncestor();
        TreeNode treeNode1 = exe.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4));

        PrintUtil.printTreeNode(treeNode1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
