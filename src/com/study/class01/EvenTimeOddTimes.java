package com.study.class01;

/*

 */
public class EvenTimeOddTimes {
    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        if (arr == null) {
            return;
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // eor = a ^ b;
        // eor != 0;
        // eor必然有一个位置上是1，这个位置，a为1，或者b为1
        int rightOne = eor & (~eor + 1); // 找出最右侧为1，其他位是0的值
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) { // arr[i] & rightOne 找出该位上也为1的数，&结果一定是rightOne，也就是不等于0
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + "; " + (eor ^ onlyOne));

    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
