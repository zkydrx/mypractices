package com.hundsun.practices.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * 文件描述
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
