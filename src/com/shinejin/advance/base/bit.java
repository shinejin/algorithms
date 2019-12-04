package com.shinejin.advance.base;

public class bit {

    public static void main(String[] args){

        System.out.println(myDiv(11, 2));
    }

    public static void testMod(int num) {
        for(int i = 1; i <= num; i++) {
            System.out.println(num + " mod " + i + "=" + (num%i));
        }
    }

    /**
     * 对于整型数a，b来说，取模运算或者求余运算的方法都是：
     * 1.求 整数商： c = a/b;
     * 2.计算模或者余数： r = a - c*b.
     */
    public static void testMod2(int num, int div) {
        int quo = num/div;
        System.out.println("被除数:" + num + " 除数：" + div + "， 整数商:" + quo);
        int mod1 = num - quo*div;
        System.out.println("被除数:" + num + " 除数：" + div + "， MOD:" + mod1 + " :" + (num%2));
    }

    public static String toARGB(int rgba) {
        return toColorHex((rgba >> 24) & 0xFF, ((rgba >> 16) & 0xff), ((rgba >> 8) & 0xff), (rgba & 0xff));
    }

    public static String toColorHex(int a, int r, int g, int b) {
        return "#" + toBrowserHexValue(a) + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.insert(0, "0");
        }
        return builder.toString().toUpperCase();
    }



    // &操作 判断奇数、偶数：
    public static void JudgeJIOU(int num) {
        //偶数的最后一位肯定是0
        boolean js = (num & 1) == 1;
        System.out.println(js ? "奇数" : "偶数");
    }

    // & 快速取模：

    //<< 和 >>
    /**
     *  a * 2 == a << 1;
        a * 4 == a << 2;
        a * 8 == a << 3;
        a * 16 == a << 4;
        a * 32 == a << 5;

        a / 2 == a >> 1;
        a / 4 == a >> 2;
        a / 8 == a >> 3;
        a / 16 == a >> 4;
        a /32 == a >> 5;

     按位异或：11为0，10为1，00为0。那么同一个数对另一个数进行2次按位抑或，仍然是本身
     交换数值
     a ^= b;
     b ^= a;
     a ^= b;

     */

    public static int myDiv2(int m, int n){
        int res = 0;
        while(m >= n){
            m -= n;
            res ++;

        }
        return res;
    }

    public static int myDiv(int m, int n){
        int res = 0;
        while(m >= n){

            int tmpN = n;
            int tmpRes = 1;
            while (m - tmpN >= tmpN){
                tmpN += tmpN;
                tmpRes += tmpRes;
            }

            m = m - tmpN;
            res += tmpRes;
        }

        return res;
    }

}
