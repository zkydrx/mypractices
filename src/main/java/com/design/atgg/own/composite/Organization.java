package com.design.atgg.own.composite;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.design.atgg.own.composite
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/5/23 2:22
 * @UpdateUser: zky
 * @UpdateDate: 2021/5/23 2:22
 * @UpdateRemark: The modified content
 * @DATE: 2021-05-23 02:22
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public abstract class Organization
{
    /**
     * 名字
     */
    private String name;
    /**
     * 描述
     */
    private String desc;

    public Organization(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
    }

    /**
     * 添加组织
     *
     * @param organization
     */
    protected void add(Organization organization)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除组织
     *
     * @param organization
     */
    protected void remove(Organization organization)
    {
        throw new UnsupportedOperationException();
    }

    abstract void print();



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
