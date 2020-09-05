package com.study.class01;

import java.util.Arrays;

/*
    选择排序: 依次找到该位置上应该放的值，也就是以位置去找数值
 */
public class SelectionSort {

    /***
     * 选择排序
     * @param arr 数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) { // 遍历 0 ～ N-2 位置，排序之后，最后N - 1位置就已经是最大的了

            int minIndex = i; // 最小值在哪个位置上 i ～ N-1，从i之后的位置开始比较
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /***
     * 交换位置
     * @param arr 数组
     * @param i 当前位置
     * @param j 最小值所在的位置
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /***
     *  为了测试写的选择排序是否正确，做一下对比
     * @param arr 数组
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 生成一个随机数组
     * @param maxSize 数组的最大长度
     * @param maxValue  数组中的最大值
     * @return 返回生成的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 这样是为了也可以生成负数，也可以直接用arr[i] = (int)((maxValue + 1) * Math.random())，是一样的，只不过都是正值
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /***
     * 复制一个相同的数组
     * @param arr 源数组
     * @return 复制出来的数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int [] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /***
     * 判断两个数组是否完全一致
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 数组一致返回true，不一致返回false
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /***
     * 打印输出该数组
     * @param arr 数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000; //测试次数
        int maxSize = 100; // 构造数组的最大长度
        int maxValue = 200; // 构造数组中的最大值
        boolean success = true; // 判断两种排序是否一致
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue); // 构造出一个数组
            int[] arr2 = copyArray(arr1); // 复制一个完全一样的数组
            selectionSort(arr1); // 选择排序
            comparator(arr2); // java提供的API排序
            if (!isEqual(arr1, arr2)) {
                success = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fuck!");

        int[] arr = generateRandomArray(10, 20);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
