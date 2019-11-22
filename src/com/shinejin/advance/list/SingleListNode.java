package com.shinejin.advance.list;

import java.util.logging.Logger;

public class SingleListNode {

    protected SingleListNode mNext;
    protected int mData;

    SingleListNode(int data) {
        mData = data;
    }

    public void display() {
        System.out.println(mData + ",");
    }
}
