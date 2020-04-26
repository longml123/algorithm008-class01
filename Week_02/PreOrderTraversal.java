package com.qunar.qboss.qer.common.lianxi.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {1, null, 3, 5};


    }

    /**
     * 自己构建栈来放二叉树节点值
     * 本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈
     * <p>
     * 首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，此时Stack里面的内容为空，
     * 所以我们优先将头结点加入Stack，然后打印。之后我们应该先打印左子树，然后右子树。
     * 所以先加入Stack的就是右子树，然后左子树。
     *
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    /**
     * 前序：根-左-右
     *
     * @param head
     */
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序：左-根-右
     *
     * @param head
     */
    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.val + "");
        inOrderRecur(head.right);
    }



    public static void preOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 1、同理创建一个Stack，然后按 左 中 右的顺序输出节点。
     * 2、尽可能的将这个节点的左子树压入Stack，此时栈顶的元素是最左侧的元素，
     * <u>其目的是找到一个最小单位的子树(也就是最左侧的一个节点)，
     * 并且在寻找的过程中记录了来源，才能返回上层</u>,
     * 同时在返回上层的时候已经处理完毕左子树了。。
     * <p>
     * 3、当处理完最小单位的子树时，返回到上层处理了中间节点。
     * （如果把整个左中右的遍历都理解成子树的话，就是处理完 左子树->中间(就是一个节点)->右子树）
     * 4、如果有右节点，其也要进行中序遍历。
     *
     * @param head
     */
    public static void inOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head; //记录根节点，便于返回
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
    }


}
