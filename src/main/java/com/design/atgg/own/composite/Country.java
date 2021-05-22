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
 * @CreateDate: 2021/5/23 2:28
 * @UpdateUser: zky
 * @UpdateDate: 2021/5/23 2:28
 * @UpdateRemark: The modified content
 * @DATE: 2021-05-23 02:28
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Country extends Organization
{

    List<Organization> companyList = new ArrayList<>();

    public Country(String name, String desc)
    {
        super(name, desc);
    }

    @Override
    void print()
    {
        System.out.println("-----------------------------" + getName() + "--------------------------");
        for (Organization organization1 : companyList)
        {
            organization1.print();
        }
    }

    /**
     * 添加组织
     *
     * @param organization
     */
    @Override
    protected void add(Organization organization)
    {
        companyList.add(organization);
    }

    /**
     * 删除组织
     *
     * @param organization
     */
    @Override
    protected void remove(Organization organization)
    {
        companyList.remove(organization);
    }

    @Override
    public String getName()
    {
        return super.getName();
    }

    @Override
    public String getDesc()
    {
        return super.getDesc();
    }
}
