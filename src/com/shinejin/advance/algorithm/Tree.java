package com.shinejin.advance.algorithm;

public class Tree {
    /**
     *
     */

    public class BinaryTree_LinkedList {
        private BinaryTree_LinkedList root;
        private int mData;
        BinaryTree_LinkedList mLeftNode;
        BinaryTree_LinkedList mRightNode;

        public BinaryTree_LinkedList(int data, BinaryTree_LinkedList l, BinaryTree_LinkedList r){
            mData = data;
            mLeftNode = l;
            mRightNode = r;
        }

        public int getData(){
            return mData;
        }

        public void setData(int data){
            mData = data;
        }

        public BinaryTree_LinkedList getLeftChildNode(){
            return mLeftNode;
        }

        public void setLeftChildNode(BinaryTree_LinkedList l){
            mLeftNode = l;
        }

        public BinaryTree_LinkedList getRightChildNode(){
            return mRightNode;
        }

        public void setRightChildNode(BinaryTree_LinkedList r){
            mRightNode = r;
        }

        public BinaryTree_LinkedList getRoot(){
            return root;
        }

        public void setRoot(BinaryTree_LinkedList node){
            root = node;
        }

        public void insertAsLeftChildNode(BinaryTree_LinkedList node){
            if(root == null) {
                root = node;
                return;
            }

            root.setLeftChildNode(node);
        }

        public void insertAsRightChildNode(BinaryTree_LinkedList node) {
            if(root == null) {
                root = node;
                return;
            }

            root.setRightChildNode(node);
        }

        //删除哪个元素，就将它设置为null。
        public void deleteNode(BinaryTree_LinkedList node) {
            node = null;
        }

        //只需要将删除根节点即可，即将根节点设置为null。
        public void clearBinaryTree(){
            root = null;
        }

        public int getTreeHeight(){
            return getNodeHeight(root);
        }

        // 获取指定节点的度
        public int getNodeHeight(BinaryTree_LinkedList node) {
            if(null == node)
                return 0;

            int leftChildHeight = getNodeHeight(getLeftChildNode());
            int rightChildHeight = getNodeHeight(getRightChildNode());

            int max = Math.max(leftChildHeight, rightChildHeight);
            return max + 1; // 加上当前节点自己
        }

        //获取二叉树的节点总数
        public int getSize(){
            return getNodeSize(root);
        }

        public int getNodeSize(BinaryTree_LinkedList node){
            if(node == null)
                return 0;

            int count = getNodeSize(getLeftChildNode()) + getNodeSize(getRightChildNode()) + 1; // 加上指定节点自己
            return count;
        }

        //获得某个节点的父节点
        public BinaryTree_LinkedList getParent(BinaryTree_LinkedList node){
            if(null == root || root == node)
                return root;

            return getNodeParent(root, node);
        }

        public BinaryTree_LinkedList getNodeParent(BinaryTree_LinkedList curNode, BinaryTree_LinkedList node){
            if(curNode == null)
                return null;

            if(curNode.getLeftChildNode() == node || curNode.getRightChildNode() == node)
                return curNode;

            BinaryTree_LinkedList parent = getNodeParent(curNode.getLeftChildNode(), node);
            if(null != parent)
                return parent;

            parent = getNodeParent(curNode.getRightChildNode(), node);
            if(null != parent)
                return parent;

            return null;
        }


        /**
         * 1、前序遍历：self -> left -> right (对于树中的任意节点，先打印这个节点，然后再打印它的左子树，最后打印它的右子树；)

         2、中序遍历：left -> self -> right (对于树中的任意节点，先打印它的左子树，然后再打印它本身，最后打印它的右子树；)

         3、后序遍历：left -> right ->s elf对于树中的任意节点，先打印它的左子树，然后打印它的右子树，最后打印这个节点本身。

         */
        public void iteratorFirstOrder(BinaryTree_LinkedList node){
            if(null == node)
                return;

            System.out.println(node.mData);
            iteratorFirstOrder(node.getLeftChildNode());
            iteratorFirstOrder(node.getRightChildNode());

        }
    }

}
