package com.study.class01;

/*
    在顺序数组中找到 <=value 最右侧的值
 */
public class BSNearRight {

    public static int nearestIndex(int[] arr, int value) {
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

    public static void main(String[] args) {
        int[] arr = {-5, -5, -4, -3, 0, 4, 5, 5, 6, 7};
        System.out.println(nearestIndex(arr, 3));
    }
}
