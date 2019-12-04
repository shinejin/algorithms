package com.shinejin.advance.base;

import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args){

        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        printListFromTailToHead(n3);
    }

    public static int getMaxLen(final String s) {

        if(null == s || s.isEmpty())
            return 0;

        int max = 0;
        int start = 0;
        do{
            String sub = new String();
            for(int i = start; i < s.length(); i++) {
                char c = s.charAt(i);
                if(sub.indexOf(c) >= 0) {

                    break;
                }
                else {
                    sub += c;
                }

                if(sub.length() > max) {
                    max = sub.length();
                }
            }

            start ++;
        }while(start < s.length());

        System.out.println("src:"+s+" max:" + max);
        return max;
    }

    public static String reverseWords(final String s) {

        if(null == s || s.isEmpty())
            return s;

        String[] arr = s.split(" ");
        if(arr.length <= 1)
            return s;

        String reverseStr = "";
        for(int i = arr.length - 1; i >= 0; i --) {

            if(reverseStr.isEmpty())
                reverseStr = arr[i].trim();
            else
                reverseStr += " " + arr[i].trim();
        }

        return  reverseStr;

    }

    private static class ListNode{
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;

        }
        int val;
        ListNode next;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(null == listNode)
            return new ArrayList();

        ListNode cur = listNode;

        ListNode orgNext = null;
        ListNode orgPrev = null;

        while(null != cur){
            orgNext = cur.next;
            cur.next = orgPrev;

            ListNode tmp = orgNext.next;
            orgNext.next = cur;

            orgPrev = cur;
            cur = tmp;
        }

        ArrayList<Integer> res = new ArrayList();

        while(cur != null){
            res.add(cur.val);
            cur = cur.next;
        }

        return res;

    }


}
