package com.effective.org.effectivejava.examples.chapter02.item06;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 文件描述
 *
 * @ProductName: IntelliJ IDEA
 * @ProjectName: mypractices
 * @Description:
 * @Author: zhouky36626
 * @date: 2023-07-26 17:40
 * @since:
 * @remark: The modified content
 * @Version: 1.0
 * Copyright © 2023 Hundsun Technologies Inc.
 * All Rights Reserved.
 */
@Slf4j
public class DirMain {
    public static void main(String[] args) {
        File file = new File("D:\\document\\hundsunWork\\temp\\20230725\\");
        if(file.isDirectory())
        {

        }

        try
        {
            throw new Exception();
        }
        catch (Exception e)
        {
            log.error("向RingBuffer队列存入数据[{}]出现异常=>", "111", e);
        }
    }
}
