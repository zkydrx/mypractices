package com.hundsun.practices.splittest;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.splittest
 * @Description: note
 * @Author: zhouky36626
 * @CreateDate: 2023-11-01 10:32:03
 * @date: 2023-11-01 10:32:03
 * @UpdateUser: zhouky36626
 * @UpdateDate: 2023-11-01 10:32:03
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @since 1.0
 * Copyright © 2023 Hundsun Technologies Inc. All Rights Reserved
 **/
public class SplitTest {
    public static void main(String[] args) {

        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(4);
        originalList.add(5);
        originalList.add(6);
        originalList.add(7);
        originalList.add(8);
        originalList.add(9);
        originalList.add(10);
        originalList.add(11);
        originalList.add(12);
        originalList.add(13);
        originalList.add(14);
        Integer chunkSize =3;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, originalList.size());
            List<Integer> chunk = originalList.subList(i, end);
            resultList.add(chunk);
        }
        for (List<Integer> integers : resultList) {
            System.out.println(integers);
        }
    }
}
