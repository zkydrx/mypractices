package com.design.atgg.own.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.design.atgg.own.composite
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/5/23 2:34
 * @UpdateUser: zky
 * @UpdateDate: 2021/5/23 2:34
 * @UpdateRemark: The modified content
 * @DATE: 2021-05-23 02:34
 * @SINCE:
 * @Version: 1.0
 *           <p>
 *           Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Company extends Organization {
	List<Organization> departmentList = new ArrayList<>();

	public Company(String name, String desc) {
		super(name, desc);
	}

	@Override
	void print() {
		System.out.println("-----------------------------" + getName() + "--------------------------");
		for (Organization organization1 : departmentList) {
			organization1.print();
		}
	}

	/**
	 * 添加组织
	 *
	 * @param organization
	 */
	@Override
	protected void add(Organization organization) {
		departmentList.add(organization);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	/**
	 * 删除组织
	 *
	 * @param organization
	 */
	@Override
	protected void remove(Organization organization) {
		departmentList.remove(organization);
	}

	@Override
	public String getDesc() {
		return super.getDesc();
	}
}
