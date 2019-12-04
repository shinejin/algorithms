package com.shinejin.advance.algorithm;

import java.util.Stack;

public class StackDemo {
    public class ArrayStack{
        private Object[] mArray;
        private int count; // 栈中元素的个数
        private int n; // 栈的大小

        public ArrayStack(int n){
            mArray = new Object[n];
            count = 0;
            this.n = n;
        }

        public boolean push(Object o) {
            if(n == count)
                return false;

            mArray[count] = o;
            count++;
            return true;
        }

        public Object pop() {
            if(count == 0)
                return null;

            Object o = mArray[count];
            mArray[count] = null;
            count --;

            return 0;
        }

        public Object peek(){
            return mArray[count];
        }
    }

    public class LinkStack{
        private class Node{

            Node(Object d, Node next){
                nData = d;
                mNext = next;
            }
            Object nData;
            Node mNext;
        }

        private Node first;
        private int n = 0;

        public LinkStack(){

        }

        public void push(Object o){

            Node lastNode = first;
            first = new Node(o, lastNode);
            n++;
        }

        public Object pop(){
            Node tmp = first;
            if(null != tmp && null != tmp.mNext) {
                first = tmp.mNext;
                n--;
            }

            return tmp.nData;
        }


    }



    enum OPT{
        ADD,
        SUB,
        PLUS,
        DIV
    }

    Stack<Integer> mStackNum = new Stack<>();
    Stack<OPT> mStackOPt = new Stack<>();

    public static void main(String[] args) {

    }

    public int calcOperation(final String calStr){

        for(char r : calStr.toCharArray()) {

        }

        return 0;
    }
}
