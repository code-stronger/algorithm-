package com.study.class01;

/*
    有序数组二分查找法
 */
public class BSExist {

    public static boolean exist(int[] sortArr, int num) {
        if (sortArr == null || sortArr.length == 0) {
            return false;
        }

        int left = 0;
        int right = sortArr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1); // mid = (left + right) / 2
            if (sortArr[mid] == num) {
                return true;
            } else if (sortArr[mid] > num) {
                right = mid - 1;
            } else {
              left = mid + 1;
            }
        }
        return sortArr[left] == num;
    }

    public static void main(String[] args) {
        int[] sortArr = {1,2,3,4,5,6,7,8,9};
        System.out.println(exist(sortArr, 0));
    }
}
