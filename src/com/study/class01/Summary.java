package com.study.class01;

import java.util.Arrays;

/*
    汇总今天所有的算法
 */
public class Summary {

    public static int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    // 交换位置
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j-1, j);
            }
        }
    }

    // 有序数组，二分查找
    public static boolean exist(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return arr[left] == value;
    }

    //在顺序数组中找到 >=value 最左侧的值
    public static int nearestLeftIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    // 在顺序数组中找到 <=value 最右侧的值
    public static int nearestRightIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    //乱序数组，局部最小值，只找到一个即可
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    // arr中，有两种数，出现奇数次，求出这两个数
    public static void printOddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }

        System.out.println(onlyOne + "; " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr1 = generateArray(10, 7);
        System.out.println("arr1: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("arr1: " + Arrays.toString(arr1));

        System.out.println("=============================");
        int[] arr2 = generateArray(10, 7);
        System.out.println("arr2: " + Arrays.toString(arr2));
        selectionSort(arr2);
        System.out.println("arr2: " + Arrays.toString(arr2));

        System.out.println("=============================");
        int[] arr3 = generateArray(10, 7);
        System.out.println("arr3: " + Arrays.toString(arr3));
        insertionSort(arr3);
        System.out.println("arr3: " + Arrays.toString(arr3));

        System.out.println("=============================");
        System.out.println("arr4: " + Arrays.toString(arr3));
        System.out.println("arr4: " + exist(arr3, 6));


        System.out.println("=============================");
        System.out.println("arr5: " + Arrays.toString(arr3));
        System.out.println("arr5: " + nearestLeftIndex(arr3, 3));

        System.out.println("=============================");
        System.out.println("arr6: " + Arrays.toString(arr3));
        System.out.println("arr6: " + nearestRightIndex(arr3, 3));

        System.out.println("=============================");
        System.out.println("arr7: " + getLessIndex(new int[]{3,1,1,5,2,4}));

        System.out.println("=============================");
        int[] arr8 = {4, 3, 4, 2, 2, 2, 4, 1, 3, 3, 1, 1, 1, 4};
        printOddTimesNum(arr8);
    }




}
