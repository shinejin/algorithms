package com.shinejin.advance.algorithm;

public class Queue {

    public class LinkQueue{
        private class Node{
            Node(Object d, Node next){
                d = mData;
                mNext = next;
            }

            Object mData;
            Node mNext;
        }

        private Node mHead = null;
        private Node mTail = null;

        public void enqueue(Object o){
            if(null == mTail){
                mHead = new Node(o, null);
                mTail = mHead;
                return;
            }

            Node newNode = new Node(o, null);
            mTail.mNext = newNode;

            mTail = newNode;

        }

        public Object dequeue(){
            if(mHead == null)
                return null;

            Object o = mHead.mData;

            mHead = mHead.mNext;
            if(null == mHead)
                mTail = null;

            return o;
        }
    }
}
