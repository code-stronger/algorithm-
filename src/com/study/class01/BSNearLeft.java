package com.study.class01;

/*
    在顺序数组中找到 >=value 最左侧的值
 */
public class BSNearLeft {

    public static int nearestIndex(int[] arr, int value) {
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,9};
        System.out.println(nearestIndex(arr, 4));
    }
}
