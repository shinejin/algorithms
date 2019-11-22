package com.shinejin.advance.base;

public class ArrayDemo {


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


}
