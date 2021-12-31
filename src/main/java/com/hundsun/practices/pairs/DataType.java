package com.hundsun.practices.pairs;

import lombok.Builder;
import lombok.Data;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.pairs
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/11/23 10:28
 * @UpdateUser: zky
 * @UpdateDate: 2021/11/23 10:28
 * @UpdateRemark: The modified content
 * @DATE: 2021-11-23 10:28
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
@Builder
public class DataType
{
    private String dataString;
    private String dataType;
}
