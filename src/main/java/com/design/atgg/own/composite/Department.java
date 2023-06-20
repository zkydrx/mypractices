package com.design.atgg.own.composite;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.design.atgg.own.composite
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/5/23 2:37
 * @UpdateUser: zky
 * @UpdateDate: 2021/5/23 2:37
 * @UpdateRemark: The modified content
 * @DATE: 2021-05-23 02:37
 * @SINCE:
 * @Version: 1.0
 *           <p>
 *           Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Department extends Organization {
	public Department(String name, String desc) {
		super(name, desc);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public String getDesc() {
		return super.getDesc();
	}

	@Override
	void print() {
		System.out.println("名称：" + getName() + " 描述：" + getDesc());
	}
}
