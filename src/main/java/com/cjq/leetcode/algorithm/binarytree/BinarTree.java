/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.binarytree
 * @className com.cjq.leetcode.algorithm.binarytree.Cjq
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Cjq
 * @description 二叉树前序遍历
 * @author chenjunqi
 * @date 2022年05月10日 下午8:13
 * @version 3.0.0
 */
public class BinarTree {

    public static void main(String[] args) {

        TreeNode right_left = new TreeNode(3);

        TreeNode right = new TreeNode(2, right_left, null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(new BinarTree().preorderTraversal(root));
    }

    /**
     * BinarTree
     * @description 递归进行二叉树的前序遍历
     * @param root 根结点
     * @param list 返回值
     * @return 遍历结果
     * @author chenjunqi
     * @date 2022/5/10 下午8:37
     * @version 3.0.0
     */
    public static List<Integer> doPreorderTraversal(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            doPreorderTraversal(root.left, list);
        }
        if (root.right != null) {
            doPreorderTraversal(root.right, list);
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return doPreorderTraversal(root, new ArrayList<>());
    }

    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
