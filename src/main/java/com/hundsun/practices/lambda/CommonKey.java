package com.hundsun.practices.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: AllKindsOfItems
 * @Package: com.hundsun.practices.lambda
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/4/18 0:09
 * @UpdateUser: zky
 * @UpdateDate: 2021/4/18 0:09
 * @UpdateRemark: The modified content
 * @DATE: 2021-04-18 00:09
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
@Builder
public class CommonKey
{
    private static final long serialVersionUID = 2725047539548917964L;

    private String investmentAccountCode;

    private String dpInterCode;

    private String dpLsDirection;

    private String dpTurnoverType;

    private String dpInvestmentType;

    private Integer expireSettleDate;

    private Integer hqDate;

    private Integer changeDate;

    private Integer stopBeginDate;

    private Integer stopTime;

    private Integer navDate;

    private Integer publishDate;
}
