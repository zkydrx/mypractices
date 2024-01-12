package com.hundsun.practices.stringtest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.stringtest
 * @Description: note
 * @Author: zhouky36626
 * @CreateDate: 2023-12-15 18:16:08
 * @date: 2023-12-15 18:16:08
 * @UpdateUser: zhouky36626
 * @UpdateDate: 2023-12-15 18:16:08
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @since 1.0
 * Copyright © 2023 Hundsun Technologies Inc. All Rights Reserved
 **/
public class StringMain {
    public static void main(String[] args) {
        String inputString = "quote_dm_bsc_bondcsiestimate_after";
        String result = inputString.replaceAll("^quote_(.*?)_after$", "$1");

        System.out.println(result);

        String pattern = "^quote_(.*?)_after$";
        String inputString1 = "quote_dm_bsc_bondcsiestimate_after";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(inputString1);

        if (matcher.matches()) {
            String result1 = matcher.group(1);
            System.out.println(result1);
        } else {
            System.out.println("String does not match the pattern.");
        }
    }
}
