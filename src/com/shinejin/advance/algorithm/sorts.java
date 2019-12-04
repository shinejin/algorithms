package com.shinejin.advance.algorithm;

public class sorts {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        System.out.println("a:"+Integer.toBinaryString(a)+" b:"+Integer.toBinaryString(b));
        a ^= b;
        System.out.println("a:"+Integer.toBinaryString(a)+" b:"+Integer.toBinaryString(b));
        b ^= a;
        System.out.println("a:"+Integer.toBinaryString(a)+" b:"+Integer.toBinaryString(b));
        a ^= b;
        System.out.println("a:"+a+" b:"+b);
//        int[] arr = new int[]{3,6,4,2,11,10,5};
//        bubble_sort2(arr);
//        printArr(arr);
//
//        int[] arr2 = new int[]{3,2,1};
//        insert_sort(arr2);
//        printArr(arr2);

//        int[] arr = new int[]{5,2,7,3,4};
//        QuickSort.quickSort(arr, 0, arr.length - 1);
//        printArr(arr);
    }

    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     针对所有的元素重复以上的步骤，除了最后一个；
     重复步骤1~3，直到排序完成。
     * @param arr
     */

    public static void bubble_sort2(int arr[]){
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] <= arr[j+1])
                    continue;

                arr[j] ^= arr[j+1];
                arr[j+1] ^= arr[j];
                arr[j] ^= arr[j+1];
            }
        }
    }

    //冒泡排序：比较相邻的元素。如果第一个比第二个大，就交换它们两个
    public static void bubble_sort(int arr[]) {
        for(int i = 0; i < arr.length; i ++) {
            //每轮排序都能把最大的数沉到尾部，所以每轮排序只需要拍[0, len- i -1]
            for(int j = 0; j < arr.length -1 -i; j ++) {
                if(arr[j] <= arr[j+1])
                    continue;

                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+ 1] = temp;


            }

            printArr(arr);
        }
    }

    /**
     * 从第一个元素开始，该元素可以认为已经被排序；
     取出下一个元素，在已经排序的元素序列中从后向前扫描；
     如果该元素（已排序）大于新元素，将该元素移到下一位置；
     重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     将新元素插入到该位置后；
     重复步骤2~5。
     * @param arr
     */
    //插入排序：从第一个元素开始，从后向前扫描，如果该元素（已排序）大于新元素，
    // 将该元素移到下一位置
    public static void insert_sort(int arr[]) {

        int current = 0;
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for(j=i-1;j >= 0 && temp < arr[j]; j--)
            {
                arr[j+1]=arr[j];  //将前面较大的元素向后移动
            }
            arr[j+1]=temp;
        }
    }

    /**
     * 快速排序：对于给定的一组元素，选择一个基准元素，通常选择第一个或者最后一个，通过一趟扫描，
     * 将序列分为两个部分，一部分比基准元素小，一部分比基准元素大，此时基准元素的的位置就是在整个序列有序后它的位置，
     * 然后用同样的方法递归地将划分的两个部分再进行上面的操作进行排序，直到序列中所有的元素都有序了为止。
     * @param
     */
    public static class QuickSort{
        public static void quickSort(int[] arr, int start, int end){
            if(start >= end)
                return;

            int partition = divide(arr, start, end);
            divide(arr, start, partition-1);
            divide(arr, partition+1, end);

        }

        public static int divide(int[] a, int start, int end){

            //每次都以最右边的元素作为基准值
            int base = a[end];

            //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环
            while(start < end){
                while (start < end && a[start] < base)
                    start++; //从左边开始遍历，如果比基准值小，就继续向右走

                //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
                if(start < end){
                    //交换
                    int tmp = a[start];
                    a[start] = a[end];
                    a[end] = tmp;
                    //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                    end--;
                }

                while(start < end && a[end] >= base)
                    end--; ////从右边开始遍历，如果比基准值大，就继续向左走

                if(start < end){
                    int tmp = a[start];
                    a[start] = a[end];
                    a[end] = tmp;
                    start++;
                }
            }

            //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
            return end;
        }
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
            if(i < (arr.length - 1))
                sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int num) {

        if(null == arr || arr.length <= 0)
            return -1;

        int low = 0, high = arr.length -1;
        int middle = 0;

        if(num < arr[low] || num > arr[high])
            return -1;

        while(low <= high) {
            middle = (low + high) / 2;
            if(num == arr[middle]) {
                return middle;
            } else if(num < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
