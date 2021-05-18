package com.hundsun.practices.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * 文件描述
 *
 **/
@Data
@Builder
public class BusihubIvsmAcc
{

    public static final String VALID_FLAG = "valid_flag";
    public static final String INVESTMENT_ACCOUNTCODE = "investment_account_code";

    /**
     * 账户编码
     */
    private String investmentAccountCode;

    /**
     * 账户名称
     */
    private String dpInvestAccountName;

    /**
     * 投资账户层级代码
     */
    private String dpInvestAccountLayer;

    /**
     * 开始日期
     */
    private String beginDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 有效标志
     */
    private String validFlag;

    /**
     * 父投资账户编码
     */
    private String parentInvestmentAccountCode;

    /**
     * 产品序号
     */
    private String fundId;

    /**
     * 资产单元序号
     */
    private String assetId;

    /**
     * 投资组合序号
     */
    private String combiId;

    /**
     *  产品代码
     */
    private String fundCode;

    /**
     * 资产单元代码
     */
    private String assetCode;

    /**
     * 投资组合代码
     */
    private String combiCode;

    /**
     * 资金账户信息 todo 暂时没有改过数据脚本  capital_account_no
     */
    private String capitalAccountNo;

}
