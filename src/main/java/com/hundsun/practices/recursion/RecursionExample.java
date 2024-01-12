package com.hundsun.practices.recursion;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.recursion
 * @Description: note
 * @Author: zhouky36626
 * @CreateDate: 2023-12-27 15:01:01
 * @date: 2023-12-27 15:01:01
 * @UpdateUser: zhouky36626
 * @UpdateDate: 2023-12-27 15:01:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @since 1.0
 * Copyright © 2023 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class RecursionExample {

    public static void main(String[] args) {
//        int n = 5;
//        long result = factorial(n);
//        System.out.println("Factorial of " + n + " is: " + result);
//        long step = step(4);
//        log.info("step:{}",step);
        int [] a = {1,1,2,1,3,4,56,2,3,2,3,4,5,234324,10,23432,3423,22,312,323,4535,23645,62566246,4534532,345778};
        mergeSort(a);
    }

    // 递归计算阶乘
    public static long factorial(int n) {
        // 基本情况：如果 n 是 0 或 1，则阶乘为 1
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // 递归调用：n 的阶乘等于 n * (n-1) 的阶乘

            long temp = n * factorial(n - 1);
            log.info("temp:{}",temp);
            return temp;
        }
    }


    /**
     * 有 n 级楼梯，一次只能爬一步或两步，问 n 级楼梯有多少种爬法？
     * @param n
     * @return
     */
    public static long step(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        long temp = step(n-1) + step(n-2);
        log.info("temp={}",temp);
        return temp;
    }



    private static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        // 区间中没有元素时不再合并
        if (left >= right) {
            return;
        }
        // 划分数组，每次一分为二
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tmp);     // 划分左区间
        mergeSort(arr, mid + 1, right, tmp); // 划分右区间

        // 合并有序序列
        int begin1 = left, end1 = mid;       // 有序序列1
        int begin2 = mid + 1, end2 = right;  // 有序序列2
        int i = left;

        while (begin1 <= end1 && begin2 <= end2) {
            if (arr[begin1] < arr[begin2]) {
                tmp[i++] = arr[begin1++];
            } else {
                tmp[i++] = arr[begin2++];
            }
        }

        // 两序列不可能同时为空，将剩余元素合并
        while (begin1 <= end1) {
            tmp[i++] = arr[begin1++];
        }

        while (begin2 <= end2) {
            tmp[i++] = arr[begin2++];
        }

        // 将合并后的序列拷贝到原数组中
        // 在这里拷贝的原因是为了保证返回到上一层递归后两个子序列中的元素是有序的
        for (int j = left; j <= right; j++) {
            arr[j] = tmp[j];
        }
    }

    // 归并排序递归实现
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }
}
