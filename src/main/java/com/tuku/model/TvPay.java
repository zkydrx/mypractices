package com.tuku.model;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-03-10
 * Time: 11:21:45
 * Description:
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA. Author: xrj Date: 2020-01-09 Time: 11:04:25
 * Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TvPay implements Serializable {

	private Long id;

	/**
	 * 订单号
	 */
	private Long orderId;

	/**
	 * 支付金额
	 */
	private BigDecimal totalFee;

	/**
	 * 微信交易号码
	 */
	private String transactionId;

	/**
	 * 交易状态，1 未支付, 2已支付, 3 已退款, 4 支付错误, 5 已关闭,6-退款审核中
	 */
	private Integer status;

	/**
	 * 支付方式，"1" 微信支付,"2" 线下支付
	 */
	private Integer payType;

	/**
	 * 支付类型 0-未付款 1-全款 2-定金 3-尾款
	 */
	private Integer paymentType;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 支付时间
	 */
	private Date payTime;

	/**
	 * 关闭时间
	 */
	private Date closedTime;

	/**
	 * 退款时间
	 */
	private Date refundTime;

	private static final long serialVersionUID = 1L;

	public static TvPayBuilder builder() {
		return new TvPayBuilder();
	}
}