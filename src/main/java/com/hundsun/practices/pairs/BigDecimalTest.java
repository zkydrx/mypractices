package com.hundsun.practices.pairs;

import java.math.BigDecimal;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.pairs
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/11/29 9:54
 * @UpdateUser: zky
 * @UpdateDate: 2021/11/29 9:54
 * @UpdateRemark: The modified content
 * @DATE: 2021-11-29 09:54
 * @SINCE:
 * @Version: 1.0
 *           <p>
 *           Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal[] bigDecimals = new BigDecimal[2];
		bigDecimals[0] = BigDecimal.valueOf(20);

		BigDecimalTest test = new BigDecimalTest();
		BigDecimal[] bigDecimals1 = test.tempCompute(bigDecimals);
		System.out.println(bigDecimals1[0]);
		System.out.println(bigDecimals1[1]);
	}

	private BigDecimal[] tempCompute(BigDecimal[] todayNotSettleOfBuy) {
		BigDecimal[] tempOne = todayNotSettleOfBuy;
		tempOne[0] = BigDecimal.valueOf(12L).add(tempOne[0]);

		return todayNotSettleOfBuy;
	}
}
