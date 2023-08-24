package org.example.s1000_1500;

import org.example.bo.TreeNode;
import org.example.util.PrintUtil;

public class S1448_CountGoodNodesinBinaryTree {

    int count = 0;
    public int goodNodes(TreeNode root) {

        recursion(root, root.val);

        return count;
    }

    private void recursion(TreeNode node, int maxVal) {

        if (node == null) {
            return;
        }

        if (maxVal <= node.val) {
            count++;
        }

        int max = Math.max(maxVal, node.val);
        recursion(node.left, max);
        recursion(node.right, max);
    }

    public static void main(String[] args) {

        Integer[] arr = {3, 1, 4, 3, null, 1, 5};
        TreeNode root = TreeNode.initByArr(arr);
        PrintUtil.printTreeNode(root);

        S1448_CountGoodNodesinBinaryTree exe = new S1448_CountGoodNodesinBinaryTree();
        System.out.println(exe.goodNodes(root));
    }


}
