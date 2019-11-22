package com.shinejin.advance.list;

import java.util.LinkedList;

public class MyLinkList {
    private SingleListNode firstNode = null;
    private int pos = 0;

    public MyLinkList(){

    }

    public void add(int idx, int data) {

        SingleListNode node = new SingleListNode(data);
        if(null == firstNode) {
            firstNode = node;
            pos = 0;
            return ;
        }

        SingleListNode cur = firstNode;



    }

}
