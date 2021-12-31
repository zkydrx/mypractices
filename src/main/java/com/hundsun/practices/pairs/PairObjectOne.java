package com.hundsun.practices.pairs;

import lombok.Data;

import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.instanceofs
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/11/22 16:01
 * @UpdateUser: zky
 * @UpdateDate: 2021/11/22 16:01
 * @UpdateRemark: The modified content
 * @DATE: 2021-11-22 16:01
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
public class PairObjectOne
{
    private String id;
    private Map<String , DataType> indexData;
}
