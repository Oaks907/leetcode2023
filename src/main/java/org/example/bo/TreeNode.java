package org.example.bo;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode initByArr(Integer[] arr) {

        TreeNode[] nodeArr = new TreeNode[arr.length];
        nodeArr[0] = new TreeNode(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                nodeArr[i] = null;
                continue;
            } else {
                nodeArr[i] = new TreeNode(arr[i]);
            }

            TreeNode parent = nodeArr[(i - 1) / 2];
            if (parent == null) {
                continue;
            }
            if ((i - 1) % 2 == 0) {
                parent.left = nodeArr[i];
            } else {
                parent.right = nodeArr[i];
            }
        }

        return nodeArr[0];
    }
}
