package com.shinejin.advance.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class CharacterAndNum {

    private static volatile CharacterAndNum mInstance = null;



    /**
     *  1: 数组中间值索引：len为奇数：中间值索引len/2; len为偶数：中间两个值的索引：(len/2 -1) , len/2
     *
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        TestGetMax();

    }

    private static int divide(int toD, int fz){
        int cnt = 0;
        int mod = 0;
        while (toD - fz >= 0) {
            toD = toD - fz;
            cnt ++;
        }
        mod = toD;
        return cnt;
    }

    /**
     * 两数之和:
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     */
    public static void TestTwoSum() {
        int[] nums = new int[]{5, 7, 11, 2};
        int target = 9;

        int[] ret = twoSum(nums, target);
        if(ret != null)
            System.out.println("ret "+ ret[0] + " " + ret[1]);
    }


    public static int[] twoSum(int[] arrSrc, int result) {

        if(null == arrSrc || arrSrc.length < 2)
            return null;

        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < arrSrc.length; i ++) {

            int exp = result - arrSrc[i];
            Integer other = cache.get(exp);
            if(null != other) {
                return new int[]{i, other};
            }

            cache.put(arrSrc[i], i);
        }

        return null;
    }

    /**
     * 两数相加
     */

    public static void addTwoNumbers() {

        int len = 'a';
        System.out.println("a:"+len);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(0, 3);
        arr1.add(0, 4);
        arr1.add(0, 2);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(0, 4);
        arr2.add(0, 6);
        arr2.add(0, 5);

        ArrayList<Integer> ret = addTwoNumbers(arr1, arr2);
        for(Integer i : ret) {
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> addTwoNumbers(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

        ArrayList<Integer> retList = new ArrayList<>();
        int len = Math.max(arr1.size(), arr2.size());
        int advance = 0;
        for(int i = 0; i < len; i ++) {


            int num1 = 0;
            int num2 = 0;
            if(i < arr1.size())
                num1 = arr1.get(i);

            if(i < arr2.size())
                num2 = arr2.get(i);

            int ret = num1 + num2 + advance;
            if((ret > 9)) {
                advance = 1;
                ret -= 10;
            } else {
                advance = 0;
            }

            retList.add(0, ret);
        }

        if(advance > 0)
            retList.add(0, advance);

        return retList;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */

    public static void TestLengthOfLongestSubstring() {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(final String s) {

        if(null == s || s.isEmpty())
            return 0;

        int maxLen = 0;
        //TODO

        return maxLen;
    }

    /**
     * 取中位数：
     */
    public static void TestGetMiddleNum() {

        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        System.out.println(getMiddleNum(arr1, arr2));
    }

    static float getMiddleNum(int[] arr1, int[]arr2) {

        /**
         * 因为都是逆序的，所以把两个数组合并在一起，取中间的数就可以了
         * 因为只需要取中间的数，所以数组创建合集的一半+1就可以了
         */
        int totalLen = arr1.length + arr2.length;

        int[] temp = new int[totalLen/2 + 1];

        int idx1 = 0, idx2 = 0;
        boolean isOdd = ((totalLen % 2) != 0);
        for (int i = 0; i < temp.length; i++) {

            do {
                if (idx1 < arr1.length && idx2 < arr2.length) {

                    if (arr1[idx1] < arr2[idx2]) {
                        temp[i] = arr1[idx1++];
                    } else {
                        temp[i] = arr2[idx2++];
                    }

                    break;
                }

                if (idx1 < arr1.length) {
                    temp[i] = arr1[idx1++];
                    break;
                }

                if (idx2 < arr2.length) {
                    temp[i] = arr2[idx2++];
                    break;
                }
            } while (false);

            if (i == (totalLen / 2)) {
                return isOdd ? temp[i] : ((float) temp[i - 1] + (float) temp[i]) / 2;
            }
        }


        return -1;
    }

    /**
     * 最长回文字符串：
     */

    public static void TestLongestPalindrome() {

        System.out.println(longestPalindrome("abbc"));
    }

    public static String longestPalindrome(String s) {

        int max = 0;

        if(s.length() <= 1)
            return s;

        int targetLeft = 0; int targeRight = 1;
        int cursor = 0;
        for(int i = 0; i < s.length(); i++) {
            if(0 == i)
                continue;

            String tmp = "";

            int l = i / 2;
            int r = ((i % 2) == 0) ? (i / 2)  : (i / 2) + 1 ;
            do{
                if(l > 0 && r < s.length()) {
                    if(s.charAt(l) == s.charAt(r)) {
                        if((r - l) > max) {
                            max = (r - l);
                            targetLeft = l;
                            targeRight = r;
                        }

                    } else {
                        break;
                    }
                }
            }while(--l > 0 && ++r < s.length());
        }

        return s.substring(targetLeft, targeRight);
    }



    /**
     * 判断数字是否是回文数：
     * @param
     * @return
     */

    public static void TestIsPalindrome() {

        System.out.println(isPalindrome(121));
    }


    public static boolean isPalindrome(int x) {

        //转换为字符串解法：
        if(false)
        {
            String s = String.valueOf(x);
            boolean isOdd = (s.length() % 2) != 0;
            int leftStart = s.length() / 2 - 1;
            int rightStart = isOdd ? s.length() / 2 + 1 : s.length() / 2;

            char[] arr = s.toCharArray();
            while (leftStart >= 0) {

                if (arr[leftStart] != arr[rightStart])
                    return false;

                leftStart--;
                rightStart++;
            }
            return true;
        }

        if(true) {

            if(x < 0)
                return false;

            if(x == 0)
                return true;

            //计算最高位数：
            int num = x;

            int[] arr = new int[1000];
            int realCnt = 0;
            while(num / 10 > 0) {
                int tmp = num / 10;
                arr[realCnt] = num - (tmp * 10);
                realCnt ++;
                num = tmp;
            }

            //last
            if(num > 0) {
                arr[realCnt++] = num;
            }

            int len = realCnt;
            boolean isOdd = (len % 2) != 0;
            int leftStart = len / 2 - 1;
            int rightStart = isOdd ? len / 2 + 1 : len / 2;

            while (leftStart >= 0) {

                if (arr[leftStart] != arr[rightStart])
                    return false;

                leftStart--;
                rightStart++;
            }
            return true;
        }

        return false;


    }

    /**
     * 两个人轮流从一个序列取数，每次只能从两端取走一个数
     */

    static void TestGetMax() {
        int[] arr = new int[]{1,1,20,8};
        System.out.println(getMax(arr,0, 3));

    }
    static int getMax(int[] a, int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum += a[i];
            i++;
        }
        return act(a, sum, 0, a.length - 1);
    }

    private static int act(int[] a, int sum, int l, int r) {
        int lmax, rmax;
        if (r - l > 1) {
            // 意思是先选一个，然后求剩下数组对方先选获得的最大值，用sum减去对方获得的最大值，即是自己的最大值
            // 然后比较选头还是尾更好
            lmax = sum - act(a, sum - a[l], l + 1, r);
            rmax = sum - act(a, sum - a[r], l, r - 1);
            return lmax > rmax ? lmax : rmax;
        } else {//剩下2个
            return a[l] > a[r] ? a[l] : a[r];
        }

    }

}

