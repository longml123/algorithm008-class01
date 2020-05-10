package com.qunar.qboss.qer.common.lianxi.tree;

import java.util.Arrays;

public class BuildTree {

    /**
     * 前序数组的左子树部分+根节点是1,2,4,5，中序数组的左子树部分+根节点是4,2,5,1。
     * 这两者的数组长度是一样的。
     * 我们可以根据中序数组的中间位置1，来确定前序数组的左右部分，
     * 由于前序数组第一个是根节点，
     * 所以其左边部分是：[1:mid_index]，右半部分是[mid_index+1:]
     * 这里的mid_index是中序数组的中间下标位置。
     * 递归函数实现如下：
     *
     * 终止条件:前序和中序数组为空
     * 根据前序数组第一个元素，拼出根节点，再将前序数组和中序数组分成两半，
     * 递归的处理前序数组左边和中序数组左边，递归的处理前序数组右边和中序数组右边。
     * @param preorder
     * @param inorder
     * @return
     */
    public  TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            //用preorder[0]去中序数组中查找对应的元素
            if (preorder[0] == inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] preLeft = Arrays.copyOfRange(preorder,1,i + 1);
                int[] preRight = Arrays.copyOfRange(preorder,i + 1,preorder.length);
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i );
                int[] inRight = Arrays.copyOfRange(inorder,i + 1, inorder.length);
                //获取左右节点
                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }



}
