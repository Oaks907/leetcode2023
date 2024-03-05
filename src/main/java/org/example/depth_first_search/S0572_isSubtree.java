package org.example.depth_first_search;

import org.example.bo.TreeNode;
import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/4 8:54
 **/
public class S0572_isSubtree {


    @Test
    public void test() {
        Integer[] arr = {1, 1};
        TreeNode treeNode = PrintUtil.constructTree(arr);

        Integer[] arr1 = {1};
        TreeNode treeNode1 = PrintUtil.constructTree(arr1);

        S0572_isSubtree exe = new S0572_isSubtree();
        boolean result = exe.isSubtree(treeNode, treeNode1);
        System.out.println(result);
    }

    @Test
    public void test1() {
        Integer[] arr = {3, 4, 5, 1, null, 2};
        TreeNode treeNode = PrintUtil.constructTree(arr);
        PrintUtil.printTreeNode(treeNode);

        Integer[] arr1 = {3, 1, 2};
        TreeNode treeNode1 = PrintUtil.constructTree(arr1);

        S0572_isSubtree exe = new S0572_isSubtree();
        boolean result = exe.isSubtree(treeNode, treeNode1);
        System.out.println(result);
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return check(node1.left, node2.left) && check(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
