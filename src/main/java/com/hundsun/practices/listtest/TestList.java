package com.hundsun.practices.listtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.listtest
 * @Description: note
 * @Author: zhouky36626
 * @CreateDate: 2024-01-09 11:15:43
 * @date: 2024-01-09 11:15:43
 * @UpdateUser: zhouky36626
 * @UpdateDate: 2024-01-09 11:15:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @since 1.0
 * Copyright © 2023 Hundsun Technologies Inc. All Rights Reserved
 **/
public class TestList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList= stringList.subList(0, 3);
        System.out.println(stringList.size());
        for (String s : stringList) {
            System.out.println("---"+s);
        }

        List<String> stringList1 = new ArrayList<>();
        stringList1.add("3");
       if(!hasElementsNotInList(stringList1,stringList)){
           for (String s : stringList1) {
               System.out.println("xxxxx"+s);
           }
       }

    }

    public static   boolean hasElementsNotInList(List<String> collect, List<String> portIdList) {
        List<String> elementsNotInList = collect.stream()
                .filter(element -> !portIdList.contains(element))
                .collect(Collectors.toList());
        return !elementsNotInList.isEmpty();
    }
}
