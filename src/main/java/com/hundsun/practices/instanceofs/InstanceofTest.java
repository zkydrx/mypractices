package com.hundsun.practices.instanceofs;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.instanceofs
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/11/19 15:44
 * @UpdateUser: zky
 * @UpdateDate: 2021/11/19 15:44
 * @UpdateRemark: The modified content
 * @DATE: 2021-11-19 15:44
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class InstanceofTest
{
    public static void main(String[] args)
    {
        Object string = "1.0";
        Object int1 = 1.0;
        if (string instanceof Number)
        {
            log.info("是字母");
        }
        if (int1 instanceof Number)
        {
            log.info("是数字");
        }
    }
}
