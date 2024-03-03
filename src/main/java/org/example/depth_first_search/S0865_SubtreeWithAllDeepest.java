package org.example.depth_first_search;

import org.example.bo.TreeNode;
import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/3 22:55
 **/
public class S0865_SubtreeWithAllDeepest {

    @Test
    public void test() {
        Integer[] arr = {0,3,1,4,null,2,null,null,6,null,5};
        TreeNode treeNode = PrintUtil.constructTree(arr);
        PrintUtil.printTreeNode(treeNode);

        S0865_SubtreeWithAllDeepest exe = new S0865_SubtreeWithAllDeepest();
        TreeNode treeNode1 = exe.subtreeWithAllDeepest(treeNode);

        PrintUtil.printTreeNode(treeNode1);
    }


    TreeNode res = null;
    int maxDepth = Integer.MIN_VALUE;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        res = root;
        recursion(root, 1);
        return res;
    }

    private Integer recursion(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }

        Integer left = recursion(node.left, depth + 1);
        Integer right = recursion(node.right, depth + 1);

        if (left.equals(right)) {
            if (left >= maxDepth) {
                res = node;
                maxDepth = left;
            }
        } else if (left > right) {
            if (left > maxDepth) {
                res = node.left;
                maxDepth = left;
            }
        } else {
            if (right > maxDepth) {
                res = node.right;
                maxDepth = right;
            }
        }
        System.out.println(node.val + ", " + left + ", " + right + ", " + maxDepth);
        return Math.max(left, right);
    }
}
