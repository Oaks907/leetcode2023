package org.example.depth_first_search;

import javafx.util.Pair;
import org.example.bo.TreeNode;
import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/4 8:10
 **/
public class S0236_lowestCommonAncestor {

    @Test
    public void test() {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = PrintUtil.constructTree(arr);
        PrintUtil.printTreeNode(treeNode);

        S0236_lowestCommonAncestor exe = new S0236_lowestCommonAncestor();
        TreeNode treeNode1 = exe.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4));

        PrintUtil.printTreeNode(treeNode1);
    }


    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        recursion(root, p, q);
        return res;
    }

    private Pair<Boolean, Boolean> recursion(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return new Pair<>(false, false);
        }
        if (res != null) {
            return new Pair<>(true, true);
        }

        Pair<Boolean, Boolean> left = recursion(root.left, p, q);
        Pair<Boolean, Boolean> right = recursion(root.right, p, q);

        Pair<Boolean, Boolean> pair;
        if (root.val == p.val) {
            pair = new Pair<>(true, left.getValue() || right.getValue());
        } else if (root.val == q.val) {
            pair = new Pair<>(left.getKey() || right.getKey(), true);
        } else {
            pair = new Pair<>(left.getKey() || right.getKey(), left.getValue() || right.getValue());
        }
        if (res == null && pair.getKey() && pair.getValue()) {
            res = root;
        }
        return pair;
    }
}
